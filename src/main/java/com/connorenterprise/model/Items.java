package com.connorenterprise.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Items {

    private SaleInfo saleInfo;
    private String id;
    private SearchInfo searchInfo;
    private String etag;
    private VolumeInfo volumeInfo;
    private String selfLink;
    private AccessInfo accessInfo;
    private String kind;

}
