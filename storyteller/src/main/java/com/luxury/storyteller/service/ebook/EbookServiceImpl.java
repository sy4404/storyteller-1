package com.luxury.storyteller.service.ebook;

import com.luxury.storyteller.dto.CommunityDto;
import com.luxury.storyteller.dto.EbookDto;
import com.luxury.storyteller.mapper.CommunityMapper;
import com.luxury.storyteller.mapper.EbookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EbookServiceImpl implements EbookService {

    private final EbookMapper ebookMapper;

    @Override
    public List<EbookDto> findEbookCategoryListAll() {
        return ebookMapper.findEbookCategoryListAll();
    }

    @Override
    public List<EbookDto> findEbookByEbookCategoryIdx(int ebookCategoryIdx) {
        return ebookMapper.findEbookByEbookCategoryIdx(ebookCategoryIdx);
    }

    @Override
    public EbookDto findEbookByEbookIdx(int ebookIdx) {
        return ebookMapper.findEbookByEbookIdx(ebookIdx);
    }

    @Override
    public EbookDto findEbookCategoryListByebookCategoryIdx(int ebookCategoryIdx) {
        return ebookMapper.findEbookCategoryListByebookCategoryIdx(ebookCategoryIdx);
    }

    @Override
    public int createEbookCategory(EbookDto ebookDto) {
        return ebookMapper.createEbookCategory(ebookDto);
    }

    @Override
    public int modifyEbookCategory(EbookDto ebookDto) {
        return ebookMapper.modifyEbookCategory(ebookDto);
    }

    @Override
    public int createEbook(EbookDto ebookDto) {
        return ebookMapper.createEbook(ebookDto);
    }

    @Override
    public int modifyEbook(EbookDto ebookDto) {
        return ebookMapper.modifyEbook(ebookDto);
    }
}
