package com.canemreayar.bookshop.mapper;

import com.canemreayar.bookshop.constants.BookShopConstants;
import com.canemreayar.bookshop.formbean.detail.PagedBookItemReviews;
import com.canemreayar.bookshop.formbean.review.BookItemReviewListBean;
import com.canemreayar.bookshop.formbean.detail.BookDetailsResponse;
import com.canemreayar.bookshop.formbean.list.BookItemBean;
import com.canemreayar.bookshop.formbean.detail.BookItemDetailBean;
import com.canemreayar.bookshop.formbean.list.BookItemsListBean;
import com.canemreayar.bookshop.formbean.list.BookListResponse;
import com.canemreayar.bookshop.formbean.list.PagedBookItemsBean;
import com.canemreayar.bookshop.formbean.review.BookItemReviewBean;
import com.canemreayar.bookshop.formbean.review.BookRatingDistributions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class BookShopMapper {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private BookShopMapper(){}

    public BookListResponse mapToBookListResponse(BookItemsListBean itemBeanList){

        BookListResponse bookListResponse = new BookListResponse();
        createPaginatedBookItems(itemBeanList, bookListResponse);
        bookListResponse.setNextPage(itemBeanList.getNextPage());

        return bookListResponse;

    }

    private void createPaginatedBookItems(BookItemsListBean itemBeanList, BookListResponse bookListResponse) {
        AtomicInteger index = new AtomicInteger(0);
        Map<Integer, List<BookItemBean>> groupedPageItems = itemBeanList.getItems().stream()
                .collect(Collectors.groupingBy(cdm -> index.getAndIncrement() / BookShopConstants.NUMBER_OF_ITEMS_PER_PAGE));

        List<PagedBookItemsBean> pagedBookItemsBeanList = new ArrayList<>();

        groupedPageItems.entrySet().stream().forEach(pageItemsMap -> {
            List<BookItemBean> singlePageItems = groupedPageItems.get(pageItemsMap.getKey());
            PagedBookItemsBean pagedBookItemsBean = new PagedBookItemsBean();
            pagedBookItemsBean.setPageItems(singlePageItems);
            pagedBookItemsBean.setPageNum(pageItemsMap.getKey()+1);
            pagedBookItemsBeanList.add(pagedBookItemsBean);
        });


        bookListResponse.setPageItemsBeanList(pagedBookItemsBeanList);
    }

    public BookDetailsResponse mapToBookDetailsResponse(BookItemDetailBean itemDetail, BookItemReviewListBean bookItemReviewListBean) {

        BookDetailsResponse bookDetailsResponse = new BookDetailsResponse();

        bookDetailsResponse.setItemId(itemDetail.getItemId());
        bookDetailsResponse.setProductName(itemDetail.getName());
        bookDetailsResponse.setDescription(itemDetail.getShortDescription());
        bookDetailsResponse.setDetailImage(itemDetail.getLargeImage());
        bookDetailsResponse.setActualPrice(itemDetail.getMsrp());
        bookDetailsResponse.setSalePrice(itemDetail.getSalePrice());

        if (itemDetail.getBrandName() != null) {
            bookDetailsResponse.setAuthor(itemDetail.getBrandName().replace(";", ","));
        }
        bookDetailsResponse.setUpc(itemDetail.getUpc());

        if(itemDetail.getOfferType() != null) {

            setBookOfferType(itemDetail, bookDetailsResponse);
        }

        setBookOnlineAvailability(itemDetail, bookDetailsResponse);

        reverseRatingDistributionsHighToLow(bookItemReviewListBean);

        formatReviewsSubmissionTimes(bookItemReviewListBean);

        bookDetailsResponse.setItemReviews(bookItemReviewListBean);

        if(bookItemReviewListBean.getReviews() != null){
            createPaginatedBookReviews(bookItemReviewListBean, bookDetailsResponse);

        }

        return bookDetailsResponse;

    }

    private void createPaginatedBookReviews(BookItemReviewListBean bookItemReviewListBean, BookDetailsResponse bookDetailsResponse) {
        AtomicInteger index = new AtomicInteger(0);
        Map<Integer, List<BookItemReviewBean>> groupedPagedBookItemReviews = bookItemReviewListBean.getReviews().stream()
                .collect(Collectors.groupingBy(cdm -> index.getAndIncrement() / BookShopConstants.NUMBER_OF_REVIEWS_PER_PAGE));

        List<PagedBookItemReviews> pagedBookItemReviewsList = new ArrayList<>();

        groupedPagedBookItemReviews.entrySet().stream().forEach(pageItemsMap -> {
            List<BookItemReviewBean> singlePageItems = groupedPagedBookItemReviews.get(pageItemsMap.getKey());
            PagedBookItemReviews pagedBookItemReviews = new PagedBookItemReviews();
            pagedBookItemReviews.setPageItems(singlePageItems);
            pagedBookItemReviews.setPageNum(pageItemsMap.getKey()+1);
            pagedBookItemReviewsList.add(pagedBookItemReviews);
        });

        bookDetailsResponse.setPagedBookItemReviewsList(pagedBookItemReviewsList);
    }

    private void setBookOnlineAvailability(BookItemDetailBean itemDetail, BookDetailsResponse bookDetailsResponse) {
        if(itemDetail.isAvailableOnline()){
            bookDetailsResponse.setAvailableOnline(BookShopConstants.ONLINE_AVAILABLE);
        }else{
            bookDetailsResponse.setAvailableOnline(BookShopConstants.ONLINE_NOT_AVAILABLE);
        }
    }

    private void setBookOfferType(BookItemDetailBean itemDetail, BookDetailsResponse bookDetailsResponse) {
        if (itemDetail.getOfferType().equals(BookShopConstants.OFFER_TYPE_ONLY_ONLINE)){
            bookDetailsResponse.setOfferType("Online");
        }else if(itemDetail.getOfferType().equals(BookShopConstants.OFFER_TYPE_ONLY_STORE)){
            bookDetailsResponse.setOfferType("Store");

        }else if(itemDetail.getOfferType().equals(BookShopConstants.OFFER_TYPE_ONLINE_AND_STORE)){
            bookDetailsResponse.setOfferType("Online and Store");

        }
    }

    private void reverseRatingDistributionsHighToLow(BookItemReviewListBean bookItemReviewListBean) {
        if(bookItemReviewListBean.getReviewStatistics() != null) {
            List<BookRatingDistributions> bookRatingDistributions = bookItemReviewListBean.getReviewStatistics().getRatingDistributions();
            Collections.reverse(bookRatingDistributions);
            bookItemReviewListBean.getReviewStatistics().setRatingDistributions(bookRatingDistributions);
        }
    }

    private void formatReviewsSubmissionTimes(BookItemReviewListBean bookItemReviewListBean) {
        List<BookItemReviewBean> reviews = bookItemReviewListBean.getReviews();
        SimpleDateFormat submissionTimeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat desiredSubmissionTimeFormat = new SimpleDateFormat("MMMM dd, yyyy");

        if(reviews != null) {
            reviews.stream().forEach(review -> {

                try {
                    Date formattedSubmissionTime = submissionTimeFormat.parse(review.getSubmissionTime());
                    String desiredSubmissionTime = desiredSubmissionTimeFormat.format(formattedSubmissionTime);
                    review.setSubmissionTime(desiredSubmissionTime);

                } catch (ParseException e) {
                    logger.info("[(formatReviewsSubmissionTimes)] Error when parse review submission time is {}",review.getSubmissionTime());
                }
            });
        }

        bookItemReviewListBean.setReviews(reviews);
    }

}
