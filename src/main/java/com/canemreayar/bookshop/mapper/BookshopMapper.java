package com.canemreayar.bookshop.mapper;

import com.canemreayar.bookshop.formbean.review.ItemReviewListBean;
import com.canemreayar.bookshop.formbean.detail.DetailOutputBean;
import com.canemreayar.bookshop.formbean.list.ItemBean;
import com.canemreayar.bookshop.formbean.detail.ItemDetailBean;
import com.canemreayar.bookshop.formbean.list.ItemListBean;
import com.canemreayar.bookshop.formbean.list.ListOutputBean;
import com.canemreayar.bookshop.formbean.list.PageItemsBean;
import com.canemreayar.bookshop.formbean.review.ItemReviewBean;
import com.canemreayar.bookshop.formbean.review.RatingDistributions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class BookshopMapper{


    public static ListOutputBean mapToListOutputBean(ItemListBean itemBeanList,int pageNum){

        AtomicInteger index = new AtomicInteger(0);
        int numberOfElementsInEachPage = 20;
        Map<Integer, List<ItemBean>> groupedPageItems = itemBeanList.getItems().stream()
                .collect(Collectors.groupingBy(cdm -> index.getAndIncrement() / numberOfElementsInEachPage));

        List<PageItemsBean> pageItemsBeanList = new ArrayList<>();

        groupedPageItems.entrySet().stream().forEach(pageItemsMap -> {
            List<ItemBean> singlePageItems = groupedPageItems.get(pageItemsMap.getKey());
            PageItemsBean pageItemsBean = new PageItemsBean();
            pageItemsBean.setPageItems(singlePageItems);
            pageItemsBean.setPageNum(pageItemsMap.getKey()+1);
            pageItemsBeanList.add(pageItemsBean);
        });


        ListOutputBean listOutputBean = new ListOutputBean();
        listOutputBean.setPageItemsBeanList(pageItemsBeanList);
        listOutputBean.setNextPage(itemBeanList.getNextPage());
        listOutputBean.setTotalPages(itemBeanList.getTotalPages());
        listOutputBean.setOpenedPageNum(pageNum);

        return listOutputBean;

    }

    public static DetailOutputBean mapToDetailOutputBean(ItemDetailBean itemDetail, ItemReviewListBean itemReviewListBean){

        DetailOutputBean detailOutputBean = new DetailOutputBean();

        detailOutputBean.setItemId(itemDetail.getItemId());
        detailOutputBean.setProductName(itemDetail.getName());
        detailOutputBean.setDescription(itemDetail.getShortDescription());
        detailOutputBean.setDetailImage(itemDetail.getLargeImage());
        if(itemDetail.getMsrp() != Double.NaN){
                detailOutputBean.setActualPrice(itemDetail.getMsrp());
        }

        detailOutputBean.setSalePrice(itemDetail.getSalePrice());
        detailOutputBean.setAuthor(itemDetail.getBrandName().replaceAll(";",","));
        detailOutputBean.setUpc(itemDetail.getUpc());

        //ApplicationUtils.setNumberOfStars(itemReviewListBean);

        reverseRatingDistributionsHighToLow(itemReviewListBean);

        formatReviewsSubmissionTimes(itemReviewListBean);


        if(itemReviewListBean != null){
            detailOutputBean.setItemReviews(itemReviewListBean);

        }

        return detailOutputBean;

    }

    private static void reverseRatingDistributionsHighToLow(ItemReviewListBean itemReviewListBean) {
        if(itemReviewListBean.getReviewStatistics() != null) {
            List<RatingDistributions> ratingDistributions = itemReviewListBean.getReviewStatistics().getRatingDistributions();
            Collections.reverse(ratingDistributions);
            itemReviewListBean.getReviewStatistics().setRatingDistributions(ratingDistributions);
        }
    }

    private static void formatReviewsSubmissionTimes(ItemReviewListBean itemReviewListBean) {
        List<ItemReviewBean> reviews = itemReviewListBean.getReviews();
        SimpleDateFormat submissionTimeFormat = new SimpleDateFormat("YYYY-MM-DD'T'hh:mm:ss");
        SimpleDateFormat desiredSubmissionTimeFormat = new SimpleDateFormat("MMMM dd, yyyy");

        if(reviews != null) {
            reviews.stream().forEach(review -> {

                try {
                    Date formattedSubmissionTime = submissionTimeFormat.parse(review.getSubmissionTime());
                    String desiredSubmissionTime = desiredSubmissionTimeFormat.format(formattedSubmissionTime);
                    review.setSubmissionTime(desiredSubmissionTime);

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            });
        }

        itemReviewListBean.setReviews(reviews);
    }

}
