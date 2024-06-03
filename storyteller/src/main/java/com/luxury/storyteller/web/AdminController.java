package com.luxury.storyteller.web;

import com.luxury.storyteller.config.auth.PrincipalDetails;
import com.luxury.storyteller.dto.CommunityDto;
import com.luxury.storyteller.dto.UserDto;
import com.luxury.storyteller.service.community.CommunityService;
import com.luxury.storyteller.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {


    /**
     * 메인페이지
     */
    @GetMapping("")
    public String mainPage(Model model) {
        return "admin/index";
    }

    /**
     * 메인페이지
     */
    @GetMapping("/login")
    public String adminLogin(Model model) {
        return "admin/login";
    }

}
