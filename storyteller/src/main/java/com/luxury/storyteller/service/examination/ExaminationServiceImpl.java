package com.luxury.storyteller.service.examination;

import com.luxury.storyteller.dto.ExaminationDto;
import com.luxury.storyteller.mapper.ExaminationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExaminationServiceImpl implements ExaminationService{

    private final ExaminationMapper examinationMapper;
    @Override
    public List<ExaminationDto> findExaminationChapterAll() {
        return examinationMapper.findExaminationChapterAll();
    }
}
