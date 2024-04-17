package com.luxury.storyteller.mapper;

import com.luxury.storyteller.dto.CommunityDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityMapper {

    List<CommunityDto> findCommunityListAll();

    CommunityDto findCommunityByCommunityIdx(int communityIdx);

    int createCommunity(CommunityDto communityDto);

    int modifyCommunity(CommunityDto communityDto);

    int deleteCommunity(int communityIdx);
}
