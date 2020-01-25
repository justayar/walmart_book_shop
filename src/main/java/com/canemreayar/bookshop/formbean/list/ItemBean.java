package com.canemreayar.bookshop.formbean.list;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemBean {

    private int itemId;
    private String name;
    private double salePrice;
    private String mediumImage;
    private String productUrl;

}
