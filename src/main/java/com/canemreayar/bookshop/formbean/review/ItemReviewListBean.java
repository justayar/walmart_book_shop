package com.canemreayar.bookshop.formbean.review;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemReviewListBean {

    private int itemId;
    private List<ItemReviewBean> reviews;
    private ReviewStatisticsBean reviewStatistics;
}
