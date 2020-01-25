package com.canemreayar.bookshop.formbean.list;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PagedBookItemsBean {

    private List<BookItemBean> pageItems;
    private int pageNum;

}
