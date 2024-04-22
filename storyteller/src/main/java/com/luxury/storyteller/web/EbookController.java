package com.luxury.storyteller.web;

import com.luxury.storyteller.service.community.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ebook")
public class EbookController {


    /**
     * 강의교재 step1 교재리스트(대분류)
     */
    @GetMapping("")
    public String ebookBefore() {

        return "ebook/before";
    }

    /**
     * 강의교재 step2 교재 리스트
     */
    @GetMapping("/{communityIdx}")
    public String ebookList(@PathVariable int communityIdx) {

        return "ebook/list";
    }
//
//    /**
//     * 강의교재 상세 페이지
//     */
//    @GetMapping("/{communityIdx}")
//    public String ebookInfo() {
//
//        return "ebook/detail";
//    }
}
