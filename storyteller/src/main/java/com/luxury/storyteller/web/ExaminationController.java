package com.luxury.storyteller.web;

import com.luxury.storyteller.config.auth.PrincipalDetails;
import com.luxury.storyteller.dto.CommunityDto;
import com.luxury.storyteller.dto.ExaminationDto;
import com.luxury.storyteller.service.community.CommunityService;
import com.luxury.storyteller.service.examination.ExaminationService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        List<ExaminationDto> nlist = examinationService.findExaminationByChapter(examinationIdx);
        model.addAttribute("nlist", nlist);

        List<ExaminationDto> list = examinationService.findexaminationSelectByexaminationChapterIdx(examinationIdx);
        //List<ExaminationDto> list = examinationService.findexaminationSelectByExaminationIdx(examinationIdx);

        model.addAttribute("lists", list);

        model.addAttribute("num", examinationIdx);
        return "examination/detail";
    }


    @ResponseBody
    @PostMapping("/submit-form/{num}")
    public String handleSubmitForm(@RequestBody List<SelectedValue> selectedValues,
                                   @PathVariable int num,
                                   @AuthenticationPrincipal PrincipalDetails principalDetails,
                                   ExaminationDto examinationDto) {

        List<ExaminationDto> list = examinationService.findExaminationByChapter(num);

        int score = 0;

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getAnswer() == selectedValues.get(i).getQuestion()){
                score += 5;
            }
        }

        examinationDto.setScore(score);
        examinationDto.setUserIdx(principalDetails.getUserIdx());
        examinationDto.setExaminationIdx(num);


        examinationService.createExaminationResult(examinationDto);

        return "redirect:/";
    }


    @Data
    public static class SelectedValue {
        private String examinationIdx;
        private int question;

        // Getter와 Setter는 생략됨 (필요 시 추가)
    }
}
