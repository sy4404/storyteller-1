package com.luxury.storyteller.service.lecture;

import com.luxury.storyteller.dto.LectureDto;
import com.luxury.storyteller.mapper.LectureMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService{

    private final LectureMapper lectureMapper;

    @Override
    public List<LectureDto> findLectureListAll() {
        return lectureMapper.findLectureListAll();
    }

    @Override
    public LectureDto findLectureByLectureIdx(int lectureIdx) {
        return lectureMapper.findLectureByLectureIdx(lectureIdx);
    }

    @Override
    public int createLecture(LectureDto lectureDto) {
        return lectureMapper.createLecture(lectureDto);
    }

    @Override
    public int modifyLecture(LectureDto lectureDto) {
        return lectureMapper.modifyLecture(lectureDto);
    }

    @Override
    public int deleteLecture(int lectureIdx) {
        return lectureMapper.deleteLecture(lectureIdx);
    }
}
