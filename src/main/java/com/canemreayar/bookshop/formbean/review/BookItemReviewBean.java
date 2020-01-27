package com.canemreayar.bookshop.formbean.review;


import com.canemreayar.bookshop.formbean.review.rate.RateBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class BookItemReviewBean {

    private String reviewer;
    private String reviewText;
    private String title;
    private RateBean overallRating;
    private int numberOfStars;
    private String submissionTime;
}
