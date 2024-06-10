package com.luxury.storyteller.dto;

import lombok.Data;

@Data
public class CommunityDto {
    private int communityIdx;
    private String title;
    private String content;
    private String userIdx;
    private int deleted;
    private int disclosure;
    private String createdAt;
}
