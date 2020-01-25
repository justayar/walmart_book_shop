package com.canemreayar.bookshop.formbean.review;


import com.canemreayar.bookshop.formbean.review.rate.RateBean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemReviewBean {

    private String reviewer;
    private String reviewText;
    private String title;
    private RateBean overallRating;
    private int numberOfStars;
    private String submissionTime;
}
