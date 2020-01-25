package com.canemreayar.bookshop.formbean.detail;

import com.canemreayar.bookshop.formbean.review.ItemReviewBean;
import com.canemreayar.bookshop.formbean.review.ItemReviewListBean;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DetailOutputBean {

    private int itemId;
    private String productName;
    private String description;
    private double actualPrice;
    private double salePrice;
    private String detailImage;
    private ItemReviewListBean itemReviews;
    private String author;
    private String upc;
}
