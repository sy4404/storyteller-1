package com.luxury.storyteller.web;

import com.luxury.storyteller.dto.UserDto;
import com.luxury.storyteller.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 메인페이지
     */
    @GetMapping("")
    public String mainPage(UserDto userDto) {

        return "index";
    }

    /**
     * 로그인 페이지
     */
    @GetMapping("/login")
    public String loginPage(UserDto userDto) {

        return "login";
    }

    /**
     * 회원가입 페이지(약관동의)
     */
    @GetMapping("/signup/agree")
    public String agreePage(UserDto userDto) {

        return "agree";
    }

    /**
     * 회원가입 페이지(정보입력)
     */
    @GetMapping("/signup/begin")
    public String beginPage(UserDto userDto) {

        return "begin";
    }

            /**
             * 회원가입 로직
             */

    /**
     * 아이디 찾기 페이지(정보입력)
     */
    @GetMapping("/idinquiry")
    public String idInquiry(UserDto userDto) {

        return "idInquiry";
    }

    /**
     * 아이디 찾기 완료 페이지
     */
    @GetMapping("/idinquiry/result")
    public String idInquiry_result(UserDto userDto) {

        return "idResult";
    }

    /**
     * 비밀번호 찾기 페이지(정보입력)
     */
    @GetMapping("/pwinquiry")
    public String pwInquiry(UserDto userDto) {

        return "pwInquiry";
    }

    /**
     * 비밀번호 찾기 완료 페이지
     */
    @GetMapping("/pwinquiry/result")
    public String pwInquiry_result(UserDto userDto) {

        return "pwResult";
    }

    /**
     * 개인정보 설정 페이지
     */
    @GetMapping("/user/info")
    public String userInfoPage(UserDto userDto) {

        return "user/info";
    }

    /**
     * 개인정보 수정 페이지
     */
    @GetMapping("/user/infomodify")
    public String userInfoModifyPage(UserDto userDto) {

        return "user/infoModify";
    }

}
