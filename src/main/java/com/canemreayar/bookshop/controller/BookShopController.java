package com.canemreayar.bookshop.controller;

import com.canemreayar.bookshop.constants.BookShopConstants;
import com.canemreayar.bookshop.formbean.review.BookItemReviewListBean;
import com.canemreayar.bookshop.util.ApplicationUtils;
import com.canemreayar.bookshop.formbean.detail.BookDetailsResponse;
import com.canemreayar.bookshop.formbean.detail.BookItemDetailBean;
import com.canemreayar.bookshop.formbean.list.BookItemsListBean;
import com.canemreayar.bookshop.formbean.list.BookListResponse;
import com.canemreayar.bookshop.mapper.BookShopMapper;
import com.canemreayar.bookshop.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BookShopController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ApplicationUtils applicationUtils;

    @Autowired
    private BookShopMapper bookShopMapper;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping(value = "/bookList")
    public ModelAndView requestBookList() {

        logger.info("[(requestHomePage()] Book List api called.");

        BookItemsListBean bookItemsListBean = bookService.getBookListItems();

        BookListResponse bookListResponse = bookShopMapper.mapToBookListResponse(bookItemsListBean, BookShopConstants.DEFAULT_OPENED_PAGE_NUM);

        logger.info("[(requestHomePage()] Book List response: {} ", bookListResponse);

        return applicationUtils.getModelAndView("bookList", "listOutput", bookListResponse);

    }

    @GetMapping(value = "/bookDetails/{itemId}")
    public ModelAndView requestBookDetails(@PathVariable("itemId") int itemId) {

        logger.info("[(requestBookDetails()] Book Details api called with parameter itemId= {}",itemId);

        BookItemDetailBean itemDetail = bookService.getBookItemDetails(itemId);

        logger.info("[(requestBookDetails()] Book Reviews service called with parameter itemId= {}",itemId);

        BookItemReviewListBean bookItemReviewListBean = bookService.getBookReviews(itemId);

        BookDetailsResponse bookDetailsResponse = bookShopMapper.mapToBookDetailsResponse(itemDetail, bookItemReviewListBean);

        logger.info("[(requestBookDetails()] Book Details api response is {}", bookDetailsResponse);

        return applicationUtils.getModelAndView("bookDetails", "detailOutput", bookDetailsResponse);
    }


}

