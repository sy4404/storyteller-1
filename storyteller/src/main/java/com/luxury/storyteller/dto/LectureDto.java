package com.luxury.storyteller.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LectureDto {
    private int lectureIdx;
    private String title;
    private String content;
    private String videoUrl;
    private String watchingTile;
    private String thumbnailUrl;
}
