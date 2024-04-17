package com.luxury.storyteller.service.lecture;

import com.luxury.storyteller.mapper.LectureMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService{

    private final LectureMapper lectureMapper;

}
