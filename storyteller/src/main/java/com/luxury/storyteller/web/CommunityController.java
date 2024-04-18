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
@RequestMapping("/community")
public class CommunityController {

    private final CommunityService communityService;

    /**
     * 공지사항 목록 페이지
     */
    @GetMapping("/notice")
    public String communityNoticePage() {

        return "community/noticeList";
    }

    /**
     * 공지사항 상세 페이지
     */
    @GetMapping("/notice/{communityIdx}")
    public String communityNoticeInfoPage(@PathVariable int communityIdx) {

        return "community/noticeInfo";
    }

    /**
     * QnA 목록 페이지
     */
    @GetMapping("/qna")
    public String communityQnaPage() {

        return "community/qnaList";
    }

    /**
     * QnA 상세 페이지
     */
    @GetMapping("/qna/{communityIdx}")
    public String communityQnaInfoPage(@PathVariable int communityIdx) {

        return "community/qnaInfo";
    }
}
