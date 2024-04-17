package com.luxury.storyteller.service.examination;

import com.luxury.storyteller.dto.ExaminationDto;

import java.util.List;

public interface ExaminationService {
    /**
     * 전체 쳅터 목록
     */
    List<ExaminationDto> findExaminationChapterAll();

}
