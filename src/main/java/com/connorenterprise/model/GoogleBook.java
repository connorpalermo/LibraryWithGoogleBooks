package com.connorenterprise.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoogleBook {
    private Items[] items;

    private String totalItems;

    private String kind;
}
