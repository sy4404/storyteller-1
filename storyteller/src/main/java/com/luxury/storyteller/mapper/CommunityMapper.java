package com.luxury.storyteller.mapper;

import com.luxury.storyteller.dto.CommunityResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityMapper {

    List<CommunityResponseDto> findCommunityListAll();
}
