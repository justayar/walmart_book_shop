package com.canemreayar.bookshop.formbean.detail;

import com.canemreayar.bookshop.formbean.review.BookItemReviewBean;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PagedBookItemReviews {

    private List<BookItemReviewBean> pageItems;
    private int pageNum;
}
