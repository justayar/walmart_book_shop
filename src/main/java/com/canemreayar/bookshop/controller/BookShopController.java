package com.canemreayar.bookshop.controller;

import com.canemreayar.bookshop.formbean.review.ItemReviewListBean;
import com.canemreayar.bookshop.util.ApplicationUtils;
import com.canemreayar.bookshop.formbean.detail.DetailOutputBean;
import com.canemreayar.bookshop.formbean.detail.ItemDetailBean;
import com.canemreayar.bookshop.formbean.list.ItemListBean;
import com.canemreayar.bookshop.formbean.list.ListOutputBean;
import com.canemreayar.bookshop.formbean.review.ItemReviewBean;
import com.canemreayar.bookshop.mapper.BookshopMapper;
import com.canemreayar.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookShopController {

    @Autowired
    BookService bookService;


    @GetMapping(value = "/bookList")
    public ModelAndView requestHomePage() {


        ItemListBean itemListBean = bookService.getHomePageBookItems();

        ListOutputBean listOutputBean = BookshopMapper.mapToListOutputBean(itemListBean,0);

        ModelAndView mv = ApplicationUtils.getModelAndView("bookList", "listOutput",listOutputBean);

        return mv;
    }


    @GetMapping(value = "/list/{pageNum}")
    public ModelAndView requestPageList(@PathVariable("pageNum") int pageNum,
                                        @PathVariable("nextPage") String nextPage) {

        ItemListBean itemListBean = bookService.getNextPageBookItems(nextPage);

        ListOutputBean listOutputBean = BookshopMapper.mapToListOutputBean(itemListBean,pageNum);

        ModelAndView mv = ApplicationUtils.getModelAndView("bookList", "listOutput",listOutputBean);

        return mv;
    }

    @GetMapping(value = "/bookDetails/{itemId}")
    public ModelAndView requestItemDetail(@PathVariable("itemId") int itemId) {


        ItemDetailBean itemDetail = bookService.getItemDetail(itemId);

        ItemReviewListBean itemReviewListBean = bookService.getItemReviews(itemId);

        DetailOutputBean detailOutputBean = BookshopMapper.mapToDetailOutputBean(itemDetail,itemReviewListBean);

        ModelAndView mv = ApplicationUtils.getModelAndView("bookDetails", "detailOutput",detailOutputBean);

        return mv;
    }


}

