package com.luxury.storyteller.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/score")
public class ScoreController {

    /**
     * 성적
     */
    @GetMapping("")
    public String score() {

        return "score/list";
    }




}
