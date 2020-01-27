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
public class PagedBookItemsBean {

    private List<BookItemBean> pageItems;
    private int pageNum;

}
