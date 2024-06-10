package com.luxury.storyteller.dto;

import lombok.Data;

@Data
public class EbookDto {
    private int ebookCategoryIdx;
    private String ebookCategoryName;
    private String ebookCategoryContent;
    private String ebookCategoryImg;
    private int ebookIdx;
    private String ebookTitle;
    private String ebookUrl;
    private int ebookType;
}
