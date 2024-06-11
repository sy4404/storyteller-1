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

    @Override
    public List<ExaminationDto> findExaminationMajorAll() {
        return examinationMapper.findExaminationMajorAll();
    }

    @Override
    public List<ExaminationDto> findExaminationChapterByExaminationMajorIdx(int examinationMajorIdx) {
        return examinationMapper.findExaminationChapterByExaminationMajorIdx(examinationMajorIdx);
    }

    @Override
    public List<ExaminationDto> findExaminationSelectByChapter(ExaminationDto examinationDto) {
        return examinationMapper.findExaminationSelectByChapter(examinationDto);
    }

    @Override
    public List<ExaminationDto> findExaminationByChapter(int examinationChapterIdx) {
        return examinationMapper.findExaminationByChapter(examinationChapterIdx);
    }

    @Override
    public int modifyExaminationMajor(ExaminationDto examinationDto) {
        return examinationMapper.modifyExaminationMajor(examinationDto);
    }

    @Override
    public int modifyExaminationChapter(ExaminationDto examinationDto) {
        return examinationMapper.modifyExaminationChapter(examinationDto);
    }

    @Override
    public ExaminationDto findExaminationMajorByexaminationMajorIdx(int examinationMajorIdx) {
        return examinationMapper.findExaminationMajorByexaminationMajorIdx(examinationMajorIdx);
    }

    @Override
    public ExaminationDto findExaminationChapterByExaminationChapterIdx(int examinationChapterIdx) {
        return examinationMapper.findExaminationChapterByExaminationChapterIdx(examinationChapterIdx);
    }
}
