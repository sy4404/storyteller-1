package com.luxury.storyteller.web;

import com.luxury.storyteller.dto.CommunityDto;
import com.luxury.storyteller.dto.LectureDto;
import com.luxury.storyteller.service.community.CommunityService;
import com.luxury.storyteller.service.lecture.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/lecture")
public class LectureController {

    private final LectureService lectureService;

    /**
     * 동영상 강의 목록 페이지
     */
    @GetMapping("")
    public String lectureListPage(Model model) {

        List<LectureDto> list = lectureService.findLectureListAll();
        model.addAttribute("lists", list);

        return "lecture/list";
    }

    /**
     * 동영상 강의 상세 페이지
     */
    @GetMapping("{lectureIdx}")
    public String lectureInfoPage(@PathVariable int lectureIdx, Model model) {
        LectureDto detail = lectureService.findLectureByLectureIdx(lectureIdx);
        model.addAttribute("detail", detail);
        return "lecture/info";
    }
}
