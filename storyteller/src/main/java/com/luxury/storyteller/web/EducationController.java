package com.luxury.storyteller.web;

import com.luxury.storyteller.dto.CommunityDto;
import com.luxury.storyteller.service.community.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/education")
public class EducationController {

    /**
     * 교육과정 페이지
     */
    @GetMapping("")
    public String communityNoticePage() {

        return "education/list";
    }


}
