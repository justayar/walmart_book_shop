package com.canemreayar.bookshop.service;

import com.canemreayar.bookshop.formbean.detail.BookItemDetailBean;
import com.canemreayar.bookshop.formbean.list.BookItemsListBean;
import com.canemreayar.bookshop.formbean.review.BookItemReviewListBean;

public interface BookService {

    BookItemsListBean getBookListItems();

    BookItemsListBean getNextPageBookItems(String nextPage);

    BookItemDetailBean getBookItemDetails(int itemId);

    BookItemReviewListBean getBookReviews(int itemId);

}
