package com.canemreayar.bookshop.formbean.list;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BookListResponse {

    private List<PagedBookItemsBean> pagedBookItemsBeanList;
    private String nextPage;
    private int totalPages;
    private int openedPageNum;


}
