package com.luxury.storyteller.web;

import com.luxury.storyteller.config.auth.PrincipalDetails;
import com.luxury.storyteller.dto.CommunityDto;
import com.luxury.storyteller.dto.UserDto;
import com.luxury.storyteller.service.community.CommunityService;
import com.luxury.storyteller.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final CommunityService communityService;

    /**
     * 메인페이지
     */
    @GetMapping("")
    public String mainPage(Model model) {
        //최신 공지사항
        CommunityDto lastCommunity = communityService.lastCommunity();
        model.addAttribute("lastCommunity", lastCommunity);
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
    @PostMapping("/signup")
    public String signup(UserDto userDto) {

        userService.createUser(userDto);

        return "redirect:/login";
    }

    /**
     * 회원가입 로직
     */

    @GetMapping("/signup/begin")
    public String beginPage(UserDto userDto) {

        return "begin";
    }

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
    @PostMapping("/idinquiry/result")
    public String idInquiry_result(UserDto userDto, Model model) {

        UserDto detail = userService.findUserByIdAndPhoneNumber(userDto);
        model.addAttribute("detail", detail);

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
    public String userInfoPage(@AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {

        UserDto detail = userService.findUserByUserIdx(principalDetails.getUserIdx());
        detail.setPhoneNumber(detail.getPhoneNumber().replaceAll("(\\d{3})(\\d{4})(\\d{4})", "$1-$2-$3"));
        model.addAttribute("detail", detail);

        return "user/info";
    }

    /**
     * 개인정보 수정 페이지
     */
    @GetMapping("/user/infomodify")
    public String userInfoModifyPage(@AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {

        UserDto detail = userService.findUserByUserIdx(principalDetails.getUserIdx());
        model.addAttribute("detail", detail);

        return "user/infoModify";
    }

}
