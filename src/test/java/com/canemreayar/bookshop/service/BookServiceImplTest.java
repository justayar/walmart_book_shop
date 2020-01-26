package com.canemreayar.bookshop.service;

import com.canemreayar.bookshop.formbean.detail.BookItemDetailBean;
import com.canemreayar.bookshop.formbean.list.BookItemsListBean;
import com.canemreayar.bookshop.formbean.review.BookItemReviewListBean;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;


@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTest {

    @InjectMocks
    @Spy
    private BookServiceImpl bookService;

    @Mock
    private RestTemplate restTemplate;


    @Before
    public void init() {

        Mockito.mockitoSession().initMocks(this);
        ReflectionTestUtils.setField(bookService, "WALMART_API_KEY", "ase2cya3wajnnvkrya4p9xma");
        ReflectionTestUtils.setField(bookService, "WALMART_LIST_REST_URL", "http://api.walmartlabs.com/v1/paginated/items");
        ReflectionTestUtils.setField(bookService, "WALMART_ITEM_DETAIL_REST_URL", "http://api.walmartlabs.com/v1/items/");
        ReflectionTestUtils.setField(bookService, "WALMART_ITEM_REVIEWS_URL", "http://api.walmartlabs.com/v1/reviews/");

    }

    @Test
    public void returnBookItemsListWhenCallingBookItemListService(){

        BookItemsListBean bookListItems = bookService.getBookListItems();

        Assert.assertEquals(200,bookListItems.getItems().size());

    }

    @Test
    public void returnDetailItemsListWhenCallingBookDetailItemService(){

        int itemId =220741;

        BookItemDetailBean bookItemDetails = bookService.getBookItemDetails(itemId);

        Assert.assertEquals("Mushrooms Demystified",bookItemDetails.getName());
        Assert.assertEquals("David Arora",bookItemDetails.getBrandName());

    }

    @Test
    public void returnNullWhenCallingBookDetailItemServiceGetException(){

        int itemId =000000000;

        BookItemDetailBean bookItemDetails = bookService.getBookItemDetails(itemId);

        Assert.assertNull(bookItemDetails.getName());

    }

    @Test
    public void returnBookReviewsWhenCallingBookReviewService(){

        int itemId =220741;

        BookItemReviewListBean bookReviews = bookService.getBookReviews(itemId);

        Assert.assertEquals("4.67",bookReviews.getReviewStatistics().getAverageOverallRating());

    }

    @Test
    public void returnNullWhenCallingBookReviewServiceGetException(){

        int itemId =22074121;

        BookItemReviewListBean bookReviews = bookService.getBookReviews(itemId);

        Assert.assertNull(bookReviews.getReviews());

    }

}