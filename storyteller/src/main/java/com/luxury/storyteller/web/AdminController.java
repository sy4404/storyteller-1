package com.luxury.storyteller.web;

import com.luxury.storyteller.dto.CommunityDto;
import com.luxury.storyteller.dto.EbookDto;
import com.luxury.storyteller.dto.ExaminationDto;
import com.luxury.storyteller.dto.UserDto;
import com.luxury.storyteller.service.community.CommunityService;
import com.luxury.storyteller.service.ebook.EbookService;
import com.luxury.storyteller.service.examination.ExaminationService;
import com.luxury.storyteller.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final CommunityService communityService;
    private final EbookService ebookService;
    private final ExaminationService examinationService;

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
    @GetMapping("/user-info/{userIdx}")
    public String adminUsersInfo(@PathVariable int userIdx, Model model) {

        UserDto detail = userService.findUserByUserIdx(userIdx);
        model.addAttribute("detail", detail);

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
     * 공지사항 수정 페이지
     */
    @GetMapping("/notice-edit/{communityIdx}")
    public String noticeEdit(@PathVariable int communityIdx, Model model) {
        CommunityDto detail = communityService.findCommunityByCommunityIdx(communityIdx);
        model.addAttribute("detail", detail);
        return "admin/noticeEdit";
    }

    /**
     * 공지사항 수정
     */
    @PostMapping("/notice-edit")
    public String noticePostEdit(CommunityDto communityDto, Model model) {
        communityService.modifyCommunity(communityDto);
        return "redirect:/admin/notice";
    }

    /**
     * 공지사항 등록
     */
    @PostMapping("/notice-write")
    public String adminNoticePostWrite(CommunityDto communityDto) {
        communityService.createCommunity(communityDto);
        return "redirect:/admin/notice";
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
        List<EbookDto> list = ebookService.findEbookCategoryListAll();
        model.addAttribute("lists", list);
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
     * 교재 등록
     */
    @PostMapping("/ebook-write")
    public String adminEbookPostWrite(EbookDto ebookDto,Model model) {
        ebookService.createEbookCategory(ebookDto);
        return "redirect:/admin/ebook";
    }

    /**
     * 교재 수정 페이지
     */
    @GetMapping("/ebook-edit/{ebookCategoryIdx}")
    public String adminEbookEdit(@PathVariable int ebookCategoryIdx, Model model) {
        EbookDto detail = ebookService.findEbookCategoryListByebookCategoryIdx(ebookCategoryIdx);
        model.addAttribute("detail", detail);
        return "admin/ebookEdit";
    }

    /**
     * 교재 수정 페이지
     */
    @PostMapping("/ebook-edit")
    public String adminEbookEdit(EbookDto ebookDto, Model model) {
        ebookService.modifyEbookCategory(ebookDto);
        return "redirect:/admin/ebook";
    }

    /**
     * 교재관리
     */
    @GetMapping("/chapter/{ebookCategoryIdx}")
    public String adminChapter(@PathVariable int ebookCategoryIdx, Model model) {
        List<EbookDto> list = ebookService.findEbookByEbookCategoryIdx(ebookCategoryIdx);

        model.addAttribute("lists", list);

        model.addAttribute("ebookCategoryIdx", ebookCategoryIdx);
        return "admin/chapter";
    }

    /**
     * 교재관리
     */
    @GetMapping("/chapter-write/{ebookCategoryIdx}")
    public String adminChapterWrite(@PathVariable int ebookCategoryIdx, Model model) {
        model.addAttribute("ebookCategoryIdx", ebookCategoryIdx);
        return "admin/chapterWrite";
    }

    /**
     * 교재관리
     */
    @PostMapping("/chapter-write")
    public String adminChapterWrite(EbookDto ebookDto, Model model) {
        ebookService.createEbook(ebookDto);
        return "redirect:/admin/chapter/" + ebookDto.getEbookCategoryIdx();
    }

    /**
     * 교재관리
     */
    @GetMapping("/chapter-edit/{ebookIdx}")
    public String adminChapterEdit(@PathVariable int ebookIdx, Model model) {
        EbookDto detail = ebookService.findEbookByEbookIdx(ebookIdx);
        model.addAttribute("detail", detail);
        return "admin/chapterEdit";
    }

    /**
     * 교재관리
     */
    @PostMapping("/chapter-edit")
    public String adminChapterEdit(EbookDto ebookDto, Model model) {
        ebookService.modifyEbook(ebookDto);
        return "redirect:/admin/chapter/" + ebookDto.getEbookCategoryIdx();
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
        List<ExaminationDto> list = examinationService.findExaminationMajorAll();
        model.addAttribute("lists", list);
        return "admin/examination";
    }

    /**
     * 모의고사 과목 등록
     */
    @GetMapping("/examination-write")
    public String adminExaminationWrite(Model model) {
        return "admin/examinationWrite";
    }

    /**
     * 모의고사 과목 수정
     */
    @GetMapping("/examination-edit/{examinationMajorIdx}")
    public String adminExaminationEdit(@PathVariable int examinationMajorIdx, Model model) {
        ExaminationDto detail = examinationService.findExaminationMajorByexaminationMajorIdx(examinationMajorIdx);
        model.addAttribute("detail", detail);
        return "admin/examinationEdit";
    }

    /**
     * 모의고사 과목 수정
     */
    @PostMapping("/examination-edit")
    public String adminExaminationPostEdit(ExaminationDto examinationDto, Model model) {
        examinationService.modifyExaminationMajor(examinationDto);
        return "redirect:/admin/examination";
    }

    /**
     * 챕터관리
     */
    @GetMapping("/examination2/{examinationMajorIdx}")
    public String adminExamination2(@PathVariable int examinationMajorIdx, Model model) {
        List<ExaminationDto> list = examinationService.findExaminationChapterByExaminationMajorIdx(examinationMajorIdx);
        model.addAttribute("lists", list);
        return "admin/examination2";
    }

    /**
     * 모의고사 챕터 등록
     */
    @GetMapping("/examination2-write/{examinationMajorIdx}")
    public String adminExamination2Write(@PathVariable int examinationMajorIdx, Model model) {
        model.addAttribute("examinationMajorIdx", examinationMajorIdx);
        return "admin/examination2Write";
    }

    /**
     * 모의고사 챕터 수정
     */
    @GetMapping("/examination2-edit/{examinationChapterIdx}")
    public String adminExamination2Edit(@PathVariable int examinationChapterIdx, Model model) {
        ExaminationDto detail = examinationService.findExaminationChapterByExaminationChapterIdx(examinationChapterIdx);
        model.addAttribute("detail", detail);
        return "admin/examination2Edit";
    }

    /**
     * 모의고사 챕터 수정
     */
    @PostMapping("/examination2-edit")
    public String adminExamination2PostEdit(ExaminationDto examinationDto, Model model) {
        examinationService.modifyExaminationChapter(examinationDto);
        return "redirect:/admin/examination2/" + examinationDto.getExaminationMajorIdx();
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
