package com.luxury.storyteller.mapper;

import com.luxury.storyteller.dto.ExaminationDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ExaminationMapper {
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
}
