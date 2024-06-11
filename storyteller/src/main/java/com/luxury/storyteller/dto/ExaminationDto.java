package com.luxury.storyteller.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ExaminationDto {
    private int examinationIdx;
    private String question;
    private int answer;
    private int questionNumber;

    private int examinationAnswerIdx;
    private int isAnswer;

    private int examinationChapterIdx;
    private int examination_chapter_idx;
    private String name;

    private int examinationMajorIdx;
    private String examinationMajorTitle;

    private int examinationSelectIdx;
    private int examinationSelectNum;
    private String examinationSelectTitle;

    private int userExaminationResultIdx;
    private int userIdx;
    private int score;
    private String createdAt;
}
