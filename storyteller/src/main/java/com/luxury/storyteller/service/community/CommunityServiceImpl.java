package com.luxury.storyteller.service.community;

import com.luxury.storyteller.dto.CommunityResponseDto;
import com.luxury.storyteller.mapper.CommunityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService{

    private final CommunityMapper communityMapper;

    @Override
    public List<CommunityResponseDto> findCommunityListAll() {
        return communityMapper.findCommunityListAll();
    }
}
