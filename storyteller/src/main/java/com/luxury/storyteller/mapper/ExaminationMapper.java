package com.luxury.storyteller.mapper;

import com.luxury.storyteller.dto.ExaminationDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ExaminationMapper {
    List<ExaminationDto> findExaminationChapterAll();
}
