package com.luxury.storyteller.service.lecture;

import com.luxury.storyteller.dto.LectureDto;

import java.util.List;

public interface LectureService {
    /**
     * 전체 강의 목록
     */
    List<LectureDto> findLectureListAll();

    /**
     * 해당 강의 정보 조회
     */
    LectureDto findLectureByLectureIdx(int lectureIdx);

    /**
     * 강의 등록
     */
    int createLecture(LectureDto lectureDto);

    /**
     * 강의 수정
     */
    int modifyLecture(LectureDto lectureDto);

    /**
     * 강의 삭제
     */
    int deleteLecture(int lectureIdx);


}
