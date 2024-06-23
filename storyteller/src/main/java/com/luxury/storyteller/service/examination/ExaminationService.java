package com.luxury.storyteller.service.examination;

import com.luxury.storyteller.dto.ExaminationDto;

import java.util.List;

public interface ExaminationService {
    /**
     * 전체 쳅터 목록
     */
    List<ExaminationDto> findExaminationChapterAll();

    /**
     * 과목 목록
     */
    List<ExaminationDto> findExaminationMajorAll();

    /**
     * 과목의 챕터 목록
     */
    List<ExaminationDto> findExaminationChapterByExaminationMajorIdx(int examinationMajorIdx);

    /**
     * 챕터의 번호별 문제
     */
    List<ExaminationDto> findExaminationSelectByChapter(ExaminationDto examinationDto);

    /**
     * 챕터 모든 문제
     */
    List<ExaminationDto> findExaminationByChapter(int examinationChapterIdx);

    /**
     * 과목 수정
     */
    int modifyExaminationMajor(ExaminationDto examinationDto);

    /**
     * 챕터 수정
     */
    int modifyExaminationChapter(ExaminationDto examinationDto);

    /**
     * 과목 상세
     */
    ExaminationDto findExaminationMajorByexaminationMajorIdx(int examinationMajorIdx);

    /**
     * 챕터 상세
     */
    ExaminationDto findExaminationChapterByExaminationChapterIdx(int examinationChapterIdx);

    /**
     * 과목 등록
     */
    int createExaminationMajor(ExaminationDto examinationDto);

    /**
     * 챕터 등록
     */
    int createExaminationChapter(ExaminationDto examinationDto);


    /**
     * 문제 등록
     */
    int createExamination(ExaminationDto examinationDto);

    /**
     * 문제 항목 등록
     */
    int createExaminationSelect(ExaminationDto examinationDto);

    /**
     * 문제 상세
     */
    ExaminationDto findExaminationByExaminationIdx(int examinationIdx);

    /**
     * 문제 상세(항목)
     */
    List<ExaminationDto> findexaminationSelectByExaminationIdx(int examinationIdx);

    /**
     * 항목삭제
     */
    int deleteExaminationSelectByExaminationIdx(int examinationIdx);

    /**
     * 문제 수정
     */
    int modifyExamination(ExaminationDto examinationDto);


    List<ExaminationDto> findexaminationSelectByexaminationChapterIdx(int examinationChapterIdx);

    int createExaminationResult(ExaminationDto examinationDto);



}
