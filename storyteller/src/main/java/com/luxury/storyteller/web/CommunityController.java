package com.luxury.storyteller.web;

import com.luxury.storyteller.dto.CommunityResponseDto;
import com.luxury.storyteller.service.community.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    @GetMapping("/")
    public void retrieveSiteList() {

        List<CommunityResponseDto> list = communityService.findCommunityListAll();
        System.out.println("=============== : "+list.size());
    }
}
