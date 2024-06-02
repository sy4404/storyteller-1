package com.luxury.storyteller.dto;

import lombok.Data;

@Data
public class CommentDto {
    private int communityIdx;
    private String title;
    private String content;
    private String writer;
    private int deleted;
    private int disclosure;
    private String createdAt;
    private String name;
    private String communityCommentIdx;
    private String comment;
}
