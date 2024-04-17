package com.luxury.storyteller.web;

import com.luxury.storyteller.dto.user.UserRequestDto;
import com.luxury.storyteller.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/")
    public String retrieveSiteList(UserRequestDto joinRequestDto) {

        int result = userService.createUser(joinRequestDto);
        System.out.println("=============== : "+result);

        return "redirect:/";
    }
}
