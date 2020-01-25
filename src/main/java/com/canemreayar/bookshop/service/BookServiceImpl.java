package com.canemreayar.bookshop.service;

import com.canemreayar.bookshop.formbean.detail.BookItemDetailBean;
import com.canemreayar.bookshop.formbean.review.BookItemReviewListBean;
import com.canemreayar.bookshop.constants.BookShopConstants;
import com.canemreayar.bookshop.formbean.list.BookItemsListBean;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class BookServiceImpl implements BookService {

    @Value("${walmart.api.key}")
    private String WALMART_API_KEY;

    @Value("${walmart.list.rest.url}")
    private String WALMART_LIST_REST_URL;

    @Value("${walmart.item.detail.rest.url}")
    private String WALMART_ITEM_DETAIL_REST_URL;

    @Value("${walmart.item.reviews.url}")
    private String WALMART_ITEM_REVIEWS_URL;

    @Autowired
    private RestTemplate restTemplate;

    private static final String API_KEY_PARAM = "&apiKey=";

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public BookItemsListBean getBookListItems() {

        logger.info("[(getBookListItems()] Book List service will be called.");

        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
                HttpClientBuilder.create().build());

        restTemplate = new RestTemplate(clientHttpRequestFactory);

        return restTemplate.getForObject(
                WALMART_LIST_REST_URL +
                        "?category=" + BookShopConstants.BOOK_CATEGORY_ID +
                        API_KEY_PARAM+ WALMART_API_KEY +
                        "&format=" + BookShopConstants.API_FORMAT +
                        "&count=200",
                BookItemsListBean.class);


    }

    public BookItemsListBean getNextPageBookItems(String nextPage) {

        return restTemplate.getForObject(
                nextPage,
                BookItemsListBean.class);

    }

    public BookItemDetailBean getBookItemDetails(int itemId) {

        logger.info("[(getBookItemDetails()] Book Item Detail service will be called with itemId= {}",itemId);

        String detailUrl = WALMART_ITEM_DETAIL_REST_URL +
                     itemId +
                     "?format=" + BookShopConstants.API_FORMAT +
                     API_KEY_PARAM + WALMART_API_KEY;

        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
                HttpClientBuilder.create().build());

        restTemplate = new RestTemplate(clientHttpRequestFactory);


        return restTemplate.getForObject(
                detailUrl,
                BookItemDetailBean.class);

    }

    public BookItemReviewListBean getBookReviews(int itemId) {

        logger.info("[(getBookReviews()] Book Reviews service will be called with itemId= {}",itemId);

        return restTemplate.getForObject(
                WALMART_ITEM_REVIEWS_URL +
                        itemId +
                        "?format=" + BookShopConstants.API_FORMAT +
                        API_KEY_PARAM + WALMART_API_KEY,
                BookItemReviewListBean.class);

    }

}
