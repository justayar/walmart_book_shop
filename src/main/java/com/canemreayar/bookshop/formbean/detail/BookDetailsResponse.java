package com.canemreayar.bookshop.formbean.detail;

import com.canemreayar.bookshop.formbean.review.BookItemReviewListBean;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BookDetailsResponse {

    private int itemId;
    private String productName;
    private String description;
    private double actualPrice;
    private double salePrice;
    private String detailImage;
    private BookItemReviewListBean itemReviews;
    private List<PagedBookItemReviews> pagedBookItemReviewsList;
    private String author;
    private String upc;
    private String offerType;
    private String availableOnline;
}
