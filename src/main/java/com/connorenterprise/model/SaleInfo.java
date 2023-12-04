package com.connorenterprise.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleInfo {

    private RetailPrice retailPrice;
    private String saleability;
    private ListPrice listPrice;
    private Offers[] offers;
    private String buyLink;
    private String isEbook;
    private String country;

}
