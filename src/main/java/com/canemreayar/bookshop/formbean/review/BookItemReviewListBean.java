package com.canemreayar.bookshop.formbean.review;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class BookItemReviewListBean {

    private int itemId;
    private List<BookItemReviewBean> reviews;
    private BookReviewStatisticsBean reviewStatistics;
}
