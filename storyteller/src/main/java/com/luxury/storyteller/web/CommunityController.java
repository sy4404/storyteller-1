package com.luxury.storyteller.web;

import com.luxury.storyteller.dto.CommentDto;
import com.luxury.storyteller.dto.CommunityDto;
import com.luxury.storyteller.service.community.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String communityNoticePage(Model model) {

        List<CommunityDto> list = communityService.findCommunityListAll();
        model.addAttribute("lists", list);

        return "community/noticeList";
    }

    /**
     * 공지사항 상세 페이지
     */
    @GetMapping("/notice/{communityIdx}")
    public String communityNoticeInfoPage(@PathVariable int communityIdx, Model model) {

        CommunityDto detail = communityService.findCommunityByCommunityIdx(communityIdx);
        model.addAttribute("dedail", detail);

        List<CommentDto> list = communityService.findCommunityCommentByCommunityIdx(communityIdx);
        model.addAttribute("lists", list);
        model.addAttribute("commentCount", list.size());

        return "community/noticeInfo";
    }

    /**
     * QnA 목록 페이지
     */
    @GetMapping("/qna")
    public String communityQnaPage(Model model) {

        List<CommunityDto> list = communityService.findCommunityQnAListAll();
        model.addAttribute("lists", list);

        return "community/qnaList";
    }

    /**
     * QnA 상세 페이지
     */
    @GetMapping("/qna/{communityIdx}")
    public String communityQnaInfoPage(@PathVariable int communityIdx, Model model) {

        CommunityDto detail = communityService.findCommunityByCommunityIdx(communityIdx);
        model.addAttribute("dedail", detail);

        return "community/qnaInfo";
    }
}
