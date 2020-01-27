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
public class BookReviewStatisticsBean {

    private String averageOverallRating;
    private List<BookRatingDistributions> ratingDistributions;
    private String totalReviewCount;

}
