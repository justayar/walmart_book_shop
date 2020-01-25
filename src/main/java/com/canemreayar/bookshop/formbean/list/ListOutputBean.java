package com.canemreayar.bookshop.formbean.list;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ListOutputBean {

    private List<PageItemsBean> pageItemsBeanList;
    private String nextPage;
    private int totalPages;
    private int openedPageNum;


}
