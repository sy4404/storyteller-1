package com.luxury.storyteller.mapper;

import com.luxury.storyteller.dto.CommunityDto;
import com.luxury.storyteller.dto.EbookDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EbookMapper {
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
