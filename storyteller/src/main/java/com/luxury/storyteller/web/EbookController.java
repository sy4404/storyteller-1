package com.luxury.storyteller.web;

import com.luxury.storyteller.dto.EbookDto;
import com.luxury.storyteller.service.community.CommunityService;
import com.luxury.storyteller.service.ebook.EbookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ebook")
public class EbookController {
    private final EbookService ebookService;

    /**
     * 강의교재 step1 교재리스트(대분류)
     */
    @GetMapping("")
    public String ebookBefore(Model model) {

        List<EbookDto> list = ebookService.findEbookCategoryListAll();
        model.addAttribute("lists", list);

        return "ebook/before";
    }

    /**
     * 강의교재 step2 교재 리스트
     */
    @GetMapping("/{communityIdx}")
    public String ebookList(@PathVariable int communityIdx, Model model) {

        List<EbookDto> list = ebookService.findEbookByEbookCategoryIdx(communityIdx);
        model.addAttribute("lists", list);

        return "ebook/list";
    }

    /**
     * 강의교재 step2 교재 리스트
     */
    @GetMapping("/pdf/{communityIdx}")
    public String ebookPdf(@PathVariable int communityIdx, Model model) {

        EbookDto list = ebookService.findEbookByEbookIdx(communityIdx);
        model.addAttribute("lists", list);

        return "ebook/detail";
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
