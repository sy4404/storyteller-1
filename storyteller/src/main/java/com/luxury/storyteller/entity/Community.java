package com.luxury.storyteller.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Community {
    private int communityIdx;
    private String title;
    private String content;
    private String writer;
    private int deleted;
    private int disclosure;
    private String createdAt;
}
