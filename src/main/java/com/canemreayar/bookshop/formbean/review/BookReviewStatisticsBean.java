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
public class BookReviewStatisticsBean {

    private String averageOverallRating;
    private List<BookRatingDistributions> bookRatingDistributions;
    private String totalReviewCount;

}
