package com.luxury.storyteller.service.ebook;

import com.luxury.storyteller.dto.CommunityDto;
import com.luxury.storyteller.dto.EbookDto;

import java.util.List;

public interface EbookService {
    /**
     * 강의 교재 대분류
     */
    List<EbookDto> findEbookCategoryListAll();

    /**
     * 강의 교재 챕터
     */
    List<EbookDto> findEbookByEbookCategoryIdx(int ebookCategoryIdx);

    /**
     * 강의 교재 상세
     */
    EbookDto findEbookByEbookIdx(int ebookIdx);


    EbookDto findEbookCategoryListByebookCategoryIdx(int ebookCategoryIdx);

    int createEbookCategory(EbookDto ebookDto);
    int modifyEbookCategory(EbookDto ebookDto);

    int createEbook(EbookDto ebookDto);

    int modifyEbook(EbookDto ebookDto);


}
