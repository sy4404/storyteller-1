package com.luxury.storyteller.mapper;

import com.luxury.storyteller.dto.LectureDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LectureMapper {
    List<LectureDto> findLectureListAll();

    LectureDto findLectureByLectureIdx(int lectureIdx);

    int createLecture(LectureDto lectureDto);

    int modifyLecture(LectureDto lectureDto);

    int deleteLecture(int lectureIdx);
}
