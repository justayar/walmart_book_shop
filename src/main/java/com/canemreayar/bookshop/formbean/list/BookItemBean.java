package com.canemreayar.bookshop.formbean.list;

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
public class BookItemBean {

    private int itemId;
    private String name;
    private double salePrice;
    private String mediumImage;
    private String productUrl;

}
