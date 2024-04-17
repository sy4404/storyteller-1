package com.luxury.storyteller.web;

import com.luxury.storyteller.dto.CommunityResponseDto;
import com.luxury.storyteller.dto.user.JoinRequestDto;
import com.luxury.storyteller.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/")
    public String retrieveSiteList(@Valid JoinRequestDto joinRequestDto) {

        int result = userService.createUser(joinRequestDto);
        System.out.println("=============== : "+result);

        return "redirect:/";
    }
}
