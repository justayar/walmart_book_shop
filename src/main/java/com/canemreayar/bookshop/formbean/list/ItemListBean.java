package com.canemreayar.bookshop.formbean.list;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class ItemListBean {

    private List<ItemBean> items;
    private int totalPages;
    private String nextPage;

    public ItemListBean() {

        items = new ArrayList<>();
    }

}
