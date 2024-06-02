package com.luxury.storyteller.service.community;

import com.luxury.storyteller.dto.CommentDto;
import com.luxury.storyteller.dto.CommunityDto;

import java.util.List;

public interface CommunityService {
    /**
     * 전체 커뮤니티 목록
     */
    List<CommunityDto> findCommunityListAll();

    /**
     * 해당 커뮤니티 정보 조회
     */
    CommunityDto findCommunityByCommunityIdx(int communityIdx);

    /**
     * 커뮤니티 등록
     */
    int createCommunity(CommunityDto communityDto);

    /**
     * 커뮤니티 수정
     */
    int modifyCommunity(CommunityDto communityDto);

    /**
     * 커뮤니티 삭제
     */
    int deleteCommunity(int communityIdx);

    /**
     * 최신 커뮤니티 1개
     */
    CommunityDto lastCommunity();


    /**
     * qna 목록
     */
    List<CommunityDto> findCommunityQnAListAll();

    /**
     * 댓글 목록
     */
    List<CommentDto> findCommunityCommentByCommunityIdx(int communityIdx);

}
