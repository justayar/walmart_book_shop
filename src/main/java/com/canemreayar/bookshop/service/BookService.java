package com.canemreayar.bookshop.service;

import com.canemreayar.bookshop.formbean.detail.ItemDetailBean;
import com.canemreayar.bookshop.formbean.list.ItemListBean;
import com.canemreayar.bookshop.formbean.review.ItemReviewBean;
import com.canemreayar.bookshop.formbean.review.ItemReviewListBean;

import java.util.List;

public interface BookService {

    ItemListBean getHomePageBookItems();

    ItemListBean getNextPageBookItems(String nextPage);

    ItemDetailBean getItemDetail(int itemId);

    ItemReviewListBean getItemReviews(int itemId);

}
