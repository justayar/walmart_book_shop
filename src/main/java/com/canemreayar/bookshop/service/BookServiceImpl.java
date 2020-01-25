package com.canemreayar.bookshop.service;

import com.canemreayar.bookshop.formbean.detail.ItemDetailBean;
import com.canemreayar.bookshop.formbean.review.ItemReviewBean;
import com.canemreayar.bookshop.formbean.review.ItemReviewListBean;
import com.canemreayar.bookshop.constants.ApplicationConstants;
import com.canemreayar.bookshop.formbean.list.ItemListBean;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.List;

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


    public ItemListBean getHomePageBookItems() {

        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
                HttpClientBuilder.create().build());

        restTemplate = new RestTemplate(clientHttpRequestFactory);

        ItemListBean itemList = restTemplate.getForObject(
                WALMART_LIST_REST_URL +
                        "?category=" + ApplicationConstants.BOOK_CATEGORY_ID +
                        "&apiKey=" + WALMART_API_KEY +
                        "&format=" + ApplicationConstants.API_FORMAT +
                        "&count=200",
                ItemListBean.class);

        return itemList;

    }

    public ItemListBean getNextPageBookItems(String nextPage) {

        ItemListBean itemList = restTemplate.getForObject(
                nextPage,
                ItemListBean.class);

        return itemList;

    }

    public ItemDetailBean getItemDetail(int itemId) {

        String detailUrl = WALMART_ITEM_DETAIL_REST_URL +
                     itemId +
                     "?format=" + ApplicationConstants.API_FORMAT +
                     "&apiKey=" + WALMART_API_KEY;

        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
                HttpClientBuilder.create().build());

        restTemplate = new RestTemplate(clientHttpRequestFactory);


        ItemDetailBean itemDetail = restTemplate.getForObject(
                detailUrl,
                ItemDetailBean.class);

        return itemDetail;

    }

    public ItemReviewListBean getItemReviews(int itemId) {

        ItemReviewListBean itemReviewList = restTemplate.getForObject(
                WALMART_ITEM_REVIEWS_URL +
                        itemId +
                        "?format=" + ApplicationConstants.API_FORMAT +
                        "&apiKey=" + WALMART_API_KEY,
                ItemReviewListBean.class);

        return itemReviewList;
    }

}
