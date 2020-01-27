package com.canemreayar.bookshop.formbean.list;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BookListResponse {

    private List<PagedBookItemsBean> pageItemsBeanList;
    private String nextPage;
    private int totalPages;
    private int openedPageNum;


}
