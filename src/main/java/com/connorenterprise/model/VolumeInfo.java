package com.connorenterprise.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VolumeInfo {

    private String pageCount;
    private String averageRating;
    private ReadingModes readingModes;
    private String infoLink;
    private String printType;
    private String allowAnonLogging;
    private String publisher;
    private String[] authors;
    private String canonicalVolumeLink;
    private String title;
    private String previewLink;
    private String description;
    private String ratingsCount;
    private ImageLinks imageLinks;
    private String contentVersion;
    private String[] categories;
    private String language;
    private String publishedDate;
    private IndustryIdentifiers[] industryIdentifiers;
    private String maturityRating;

}
