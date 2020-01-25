package com.canemreayar.bookshop.formbean.list;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class BookItemsListBean {

    private List<BookItemBean> items;
    private int totalPages;
    private String nextPage;

    public BookItemsListBean() {

        items = new ArrayList<>();
    }

}
