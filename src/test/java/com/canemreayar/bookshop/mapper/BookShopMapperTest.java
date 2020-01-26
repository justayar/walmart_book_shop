package com.canemreayar.bookshop.mapper;

import com.canemreayar.bookshop.formbean.detail.BookDetailsResponse;
import com.canemreayar.bookshop.formbean.detail.BookItemDetailBean;
import com.canemreayar.bookshop.formbean.list.BookItemBean;
import com.canemreayar.bookshop.formbean.list.BookItemsListBean;
import com.canemreayar.bookshop.formbean.list.BookListResponse;
import com.canemreayar.bookshop.formbean.review.BookItemReviewBean;
import com.canemreayar.bookshop.formbean.review.BookItemReviewListBean;
import com.canemreayar.bookshop.formbean.review.BookRatingDistributions;
import com.canemreayar.bookshop.formbean.review.BookReviewStatisticsBean;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BookShopMapperTest {

    @InjectMocks
    BookShopMapper bookShopMapper;


    @Before
    public void init(){

    }


    @Test
    public void returnNullPageItemsBookListResponseWhenServiceResponseIsEmpty(){

        BookItemsListBean itemBeanList = new BookItemsListBean();

        BookListResponse bookListResponse = bookShopMapper.mapToBookListResponse(itemBeanList, 0);

        Assert.assertEquals(0,bookListResponse.getPageItemsBeanList().size());

    }

    @Test
    public void returnPageItemsBookListResponseWhenServiceBooksListNumberIsLessThanTwenty(){

        BookItemsListBean bookItemsListBean = new BookItemsListBean();
        List<BookItemBean> bookItemBeanList = new ArrayList<>();
        for(int i=0;i<10;i++){
            BookItemBean bookItemBean = new BookItemBean();
            bookItemBean.setName("Mole People");
            bookItemBeanList.add(bookItemBean);
        }
        bookItemsListBean.setItems(bookItemBeanList);

        BookListResponse bookListResponse = bookShopMapper.mapToBookListResponse(bookItemsListBean, 0);

        Assert.assertEquals(1,bookListResponse.getPageItemsBeanList().size());

    }

    @Test
    public void returnPageItemsBookListResponseWhenServiceBooksListNumberIsMoreThanTwenty(){

        BookItemsListBean bookItemsListBean = new BookItemsListBean();
        List<BookItemBean> bookItemBeanList = new ArrayList<>();
        for(int i=0;i<21;i++){
            BookItemBean bookItemBean = new BookItemBean();
            bookItemBean.setName("Mole People");
            bookItemBeanList.add(bookItemBean);
        }
        bookItemsListBean.setItems(bookItemBeanList);

        BookListResponse bookListResponse = bookShopMapper.mapToBookListResponse(bookItemsListBean, 0);

        Assert.assertEquals(2,bookListResponse.getPageItemsBeanList().size());

    }



    @Test
    public void returnNullPageItemDetailsBookListResponseWhenServiceResponseIsEmpty(){

        BookItemDetailBean bookItemDetailBean = new BookItemDetailBean();
        BookItemReviewListBean bookItemReviewListBean = new BookItemReviewListBean();

        BookDetailsResponse bookDetailsResponse = bookShopMapper.mapToBookDetailsResponse(bookItemDetailBean, bookItemReviewListBean);

        Assert.assertNull(null,bookDetailsResponse.getAuthor());

    }

    @Test
    public void returnPageItemDetailsBookListResponseWhenServiceResponseOneAuthorExist(){

        BookItemDetailBean bookItemDetailBean = new BookItemDetailBean();
        bookItemDetailBean.setBrandName("Test");
        bookItemDetailBean.setShortDescription("Desc");
        BookItemReviewListBean bookItemReviewListBean = new BookItemReviewListBean();

        BookDetailsResponse bookDetailsResponse = bookShopMapper.mapToBookDetailsResponse(bookItemDetailBean, bookItemReviewListBean);

        Assert.assertEquals("Test",bookDetailsResponse.getAuthor());
        Assert.assertEquals("Desc",bookDetailsResponse.getDescription());

    }

    @Test
    public void returnPageItemDetailsBookListResponseWhenServiceResponseMoreAuthorExists(){

        BookItemDetailBean bookItemDetailBean = new BookItemDetailBean();
        bookItemDetailBean.setBrandName("Test1;Test2");
        BookItemReviewListBean bookItemReviewListBean = new BookItemReviewListBean();

        BookDetailsResponse bookDetailsResponse = bookShopMapper.mapToBookDetailsResponse(bookItemDetailBean, bookItemReviewListBean);

        Assert.assertEquals("Test1,Test2",bookDetailsResponse.getAuthor());

    }

    @Test
    public void returnOnlineOnlyOfferTypeResponseWhenBookOfferTypeIsOnlyOnline(){

        BookItemDetailBean bookItemDetailBean = new BookItemDetailBean();
        bookItemDetailBean.setOfferType("ONLINE_ONLY");
        BookItemReviewListBean bookItemReviewListBean = new BookItemReviewListBean();

        BookDetailsResponse bookDetailsResponse = bookShopMapper.mapToBookDetailsResponse(bookItemDetailBean, bookItemReviewListBean);

        Assert.assertEquals("Online",bookDetailsResponse.getOfferType());

    }

    @Test
    public void returnStoreOnlyOfferTypeResponseWhenBookOfferTypeIsStoreOnline(){

        BookItemDetailBean bookItemDetailBean = new BookItemDetailBean();
        bookItemDetailBean.setOfferType("STORE_ONLY");
        BookItemReviewListBean bookItemReviewListBean = new BookItemReviewListBean();

        BookDetailsResponse bookDetailsResponse = bookShopMapper.mapToBookDetailsResponse(bookItemDetailBean, bookItemReviewListBean);

        Assert.assertEquals("Store",bookDetailsResponse.getOfferType());

    }

    @Test
    public void returnStoreAndOnlineOnlyOfferTypeResponseWhenBookOfferTypeIsStoreAndOnline(){

        BookItemDetailBean bookItemDetailBean = new BookItemDetailBean();
        bookItemDetailBean.setOfferType("ONLINE_AND_STORE");
        BookItemReviewListBean bookItemReviewListBean = new BookItemReviewListBean();

        BookDetailsResponse bookDetailsResponse = bookShopMapper.mapToBookDetailsResponse(bookItemDetailBean, bookItemReviewListBean);

        Assert.assertEquals("Online and Store",bookDetailsResponse.getOfferType());

    }

    @Test
    public void returnReviewDistributionsHighToLowResponseWhenDistributionsGet(){

        BookItemDetailBean bookItemDetailBean = new BookItemDetailBean();
        BookItemReviewListBean bookItemReviewListBean = new BookItemReviewListBean();
        BookReviewStatisticsBean bookReviewStatisticsBean = new BookReviewStatisticsBean();
        List<BookRatingDistributions> ratingDistributions = new ArrayList<>();
        for(int i=0;i<5;i++){
            BookRatingDistributions bookRatingDistributions = new BookRatingDistributions();
            bookRatingDistributions.setCount("0");
            bookRatingDistributions.setRatingValue(i+1+"");
            ratingDistributions.add(bookRatingDistributions);
        }

        bookReviewStatisticsBean.setRatingDistributions(ratingDistributions);
        bookItemReviewListBean.setReviewStatistics(bookReviewStatisticsBean);


        BookDetailsResponse bookDetailsResponse = bookShopMapper.mapToBookDetailsResponse(bookItemDetailBean, bookItemReviewListBean);

        String initialDistributionRatingValue = bookDetailsResponse.getItemReviews().getReviewStatistics().getRatingDistributions().get(0).getRatingValue();

        Assert.assertEquals("5",initialDistributionRatingValue);

    }

    @Test
    public void returnOnlineAvailabilityWhenAvailableOnlineIsTrue(){

        BookItemDetailBean bookItemDetailBean = new BookItemDetailBean();
        bookItemDetailBean.setAvailableOnline(true);
        BookItemReviewListBean bookItemReviewListBean = new BookItemReviewListBean();

        BookDetailsResponse bookDetailsResponse = bookShopMapper.mapToBookDetailsResponse(bookItemDetailBean, bookItemReviewListBean);

        Assert.assertEquals("Available",bookDetailsResponse.getAvailableOnline());

    }

    @Test
    public void returnOnlineAvailabilityWhenAvailableOnlineIsFalse(){

        BookItemDetailBean bookItemDetailBean = new BookItemDetailBean();
        bookItemDetailBean.setAvailableOnline(false);
        BookItemReviewListBean bookItemReviewListBean = new BookItemReviewListBean();

        BookDetailsResponse bookDetailsResponse = bookShopMapper.mapToBookDetailsResponse(bookItemDetailBean, bookItemReviewListBean);

        Assert.assertEquals("Not Available",bookDetailsResponse.getAvailableOnline());

    }

    @Test
    public void returnCorrectFormattedSubmissionTimeWhenReviewSubmissionTimeIsValid(){

        BookItemDetailBean bookItemDetailBean = new BookItemDetailBean();
        BookItemReviewListBean bookItemReviewListBean = new BookItemReviewListBean();

        List<BookItemReviewBean> bookItemReviewBeans = new ArrayList<>();
        BookItemReviewBean bookItemReviewBean = new BookItemReviewBean();
        bookItemReviewBean.setSubmissionTime("2011-10-23T17:00:00");
        bookItemReviewBeans.add(bookItemReviewBean);
        bookItemReviewListBean.setReviews(bookItemReviewBeans);

        BookDetailsResponse bookDetailsResponse = bookShopMapper.mapToBookDetailsResponse(bookItemDetailBean, bookItemReviewListBean);
        String submissionTime = bookDetailsResponse.getItemReviews().getReviews().get(0).getSubmissionTime();

        Assert.assertEquals("October 23, 2011", submissionTime);

    }



}