package com.luxury.storyteller.service.community;

import com.luxury.storyteller.dto.CommunityResponseDto;

import java.util.List;

public interface CommunityService {
    /**
     * 전체 커뮤니티 목록
     *
     * @return 전체 사업장 정보 목록.
     */
    List<CommunityResponseDto> findCommunityListAll();
}
