package com.luxury.storyteller.web;

import com.luxury.storyteller.dto.CommunityDto;
import com.luxury.storyteller.dto.ExaminationDto;
import com.luxury.storyteller.service.community.CommunityService;
import com.luxury.storyteller.service.examination.ExaminationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/examination")
public class ExaminationController {

    private final ExaminationService examinationService;
    /**
     * 시험
     */

    private final CommunityService communityService;

    @GetMapping("")
    public String examinationBefore(Model model) {

        List<ExaminationDto> list = examinationService.findExaminationMajorAll();
        model.addAttribute("lists", list);

        return "examination/before";
    }

    @GetMapping("{examinationMajorIdx}")
    public String examinationList(@PathVariable int examinationMajorIdx, Model model) {
        List<ExaminationDto> list = examinationService.findExaminationChapterByExaminationMajorIdx(examinationMajorIdx);
        model.addAttribute("lists", list);
        return "examination/list";
    }

    @GetMapping("/ex/{examinationIdx}")
    public String examinationDetail(@PathVariable int examinationIdx, Model model) {
        ExaminationDto detail = examinationService.findExaminationByExaminationIdx(examinationIdx);
        List<ExaminationDto> list = examinationService.findexaminationSelectByExaminationIdx(examinationIdx);

        model.addAttribute("detail", detail);
        model.addAttribute("lists", list);

        model.addAttribute("num", examinationIdx);
        return "examination/detail";
    }
}
