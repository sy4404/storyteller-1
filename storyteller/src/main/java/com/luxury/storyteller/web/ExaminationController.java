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
@RequestMapping("/examination")
public class ExaminationController {

    /**
     * 시험
     */

    private final CommunityService communityService;

    @GetMapping("")
    public String examinationBefore() {


        return "examination/before";
    }

    @GetMapping("{communityIdx}")
    public String examinationList(@PathVariable int communityIdx) {


        return "examination/list";
    }
}
