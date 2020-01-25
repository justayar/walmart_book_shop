package com.canemreayar.bookshop.formbean.detail;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDetailBean {

    private int itemId;
    private String name;
    private double salePrice;
    private String shortDescription;
    private String largeImage;
    private double msrp;
    private String brandName;
    private String upc;




}
