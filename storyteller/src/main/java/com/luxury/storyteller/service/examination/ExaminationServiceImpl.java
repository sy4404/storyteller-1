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

    @Override
    public int createExaminationMajor(ExaminationDto examinationDto) {
        return examinationMapper.createExaminationMajor(examinationDto);
    }

    @Override
    public int createExaminationChapter(ExaminationDto examinationDto) {
        return examinationMapper.createExaminationChapter(examinationDto);
    }

    @Override
    public int createExamination(ExaminationDto examinationDto) {
        return examinationMapper.createExamination(examinationDto);
    }

    @Override
    public int createExaminationSelect(ExaminationDto examinationDto) {
        return examinationMapper.createExaminationSelect(examinationDto);
    }

    @Override
    public ExaminationDto findExaminationByExaminationIdx(int examinationIdx) {
        return examinationMapper.findExaminationByExaminationIdx(examinationIdx);
    }

    @Override
    public List<ExaminationDto> findexaminationSelectByExaminationIdx(int examinationIdx) {
        return examinationMapper.findexaminationSelectByExaminationIdx(examinationIdx);
    }

    @Override
    public int deleteExaminationSelectByExaminationIdx(int examinationIdx) {
        return examinationMapper.deleteExaminationSelectByExaminationIdx(examinationIdx);
    }

    @Override
    public int modifyExamination(ExaminationDto examinationDto) {
        return examinationMapper.modifyExamination(examinationDto);
    }

    @Override
    public List<ExaminationDto> findexaminationSelectByexaminationChapterIdx(int examinationChapterIdx) {
        return examinationMapper.findexaminationSelectByexaminationChapterIdx(examinationChapterIdx);
    }

    @Override
    public int createExaminationResult(ExaminationDto examinationDto) {
        return examinationMapper.createExaminationResult(examinationDto);
    }
}
