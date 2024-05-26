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
}
