package com.luxury.storyteller.web;

import com.luxury.storyteller.dto.CommunityDto;
import com.luxury.storyteller.dto.UserDto;
import com.luxury.storyteller.service.community.CommunityService;
import com.luxury.storyteller.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final CommunityService communityService;

    /**
     * 메인페이지
     */
    @GetMapping("/index")
    public String mainPage(Model model) {
        return "admin/index";
    }

    /**
     * 로그인
     */
    @GetMapping("/login")
    public String adminLogin(Model model) {
        return "admin/login";
    }

    /**
     * 회원관리
     */
    @GetMapping("/users")
    public String adminUsers(Model model) {
        List<UserDto> list = userService.findByUserAll();
        model.addAttribute("lists", list);
        return "admin/users";
    }

    /**
     * 회원관리
     */
    @GetMapping("/user-info")
    public String adminUsersInfo(Model model) {
        return "admin/usersInfo";
    }

    /**
     * 공지사항
     */
    @GetMapping("/notice")
    public String adminNotice(Model model) {
        List<CommunityDto> list = communityService.findCommunityListAll();
        model.addAttribute("lists", list);
        return "admin/notice";
    }

    /**
     * 공지사항 등록 페이지
     */
    @GetMapping("/notice-write")
    public String adminNoticeWrite(Model model) {
        return "admin/noticeWrite";
    }

    /**
     * QnA
     */
    @GetMapping("/qna")
    public String adminQna(Model model) {
        return "admin/qna";
    }

    /**
     * 교재관리
     */
    @GetMapping("/ebook")
    public String adminEbook(Model model) {
        return "admin/ebook";
    }

    /**
     * 교재 등록
     */
    @GetMapping("/ebook-write")
    public String adminEbookWrite(Model model) {
        return "admin/ebookWrite";
    }

    /**
     * 교재관리
     */
    @GetMapping("/chapter")
    public String adminChapter(Model model) {
        return "admin/chapter";
    }

    /**
     * 교재관리
     */
    @GetMapping("/chapter-write")
    public String adminChapterWrite(Model model) {
        return "admin/chapterWrite";
    }

    /**
     * 교재관리
     */
    @GetMapping("/lecture")
    public String adminLecture(Model model) {
        return "admin/lecture";
    }

    /**
     * 교재관리
     */
    @GetMapping("/lecture-write")
    public String adminLectureWrite(Model model) {
        return "admin/lectureWrite";
    }

    /**
     * 모의고사
     */
    @GetMapping("/examination")
    public String adminExamination(Model model) {
        return "admin/examination";
    }

    /**
     * 모의고사examination-write
     */
    @GetMapping("/examination-write")
    public String adminExaminationWrite(Model model) {
        return "admin/examinationWrite";
    }

    /**
     * 교재관리
     */
    @GetMapping("/examination2")
    public String adminExamination2(Model model) {
        return "admin/examination2";
    }

    /**
     * 교재관리
     */
    @GetMapping("/score")
    public String adminScore(Model model) {
        return "admin/score";
    }

    /**
     * 교재관리
     */
    @GetMapping("/attendance")
    public String adminAttendance(Model model) {
        return "admin/attendance";
    }
}
