package com.luxury.storyteller.web;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.luxury.storyteller.dto.*;
import com.luxury.storyteller.service.UploadService;
import com.luxury.storyteller.service.attendance.AttendanceService;
import com.luxury.storyteller.service.community.CommunityService;
import com.luxury.storyteller.service.ebook.EbookService;
import com.luxury.storyteller.service.examination.ExaminationService;
import com.luxury.storyteller.service.lecture.LectureService;
import com.luxury.storyteller.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Properties;


@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final CommunityService communityService;
    private final EbookService ebookService;
    private final ExaminationService examinationService;
    private final LectureService lectureService;
    private final UploadService uploadService;
    private final AttendanceService attendanceService;

    @Value("${ftp.ip}")
    protected String ftpIp;




    /**
     * 메인페이지
     */
    @GetMapping("/index")
    public String mainPage(Model model) {
       // System.out.println(ftpIp);


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
     * 회원 수정
     */
    @PostMapping("/user-edit")
    public String adminUsersEdit(@RequestParam("files") MultipartFile files, UserDto userDto) {
        if (!files.isEmpty()) {
            String fileUUID = uploadService.uploadFileToServer(files, "/var/lib/tomcat9/webapps/img/storyteller/user");
            userDto.setProfileUrl(ftpIp + ":8080/img/storyteller/user/" + fileUUID);

//            String videoFilePath = "C:\\file\\test.mp4"; // 동영상 파일 경로
//            String thumbnailFilePath = "C:\\file\\thumbnail.jpg"; // 썸네일 저장 경로
//
//            //String videoFilePath = "/var/lib/tomcat9/webapps/img/storyteller/user/" + fileUUID;
//            //String thumbnailFilePath = "/var/lib/tomcat9/webapps/img/storyteller/user/thumbnail/thumbnail_" + fileUUID;
//
//            userDto.setProfileUrl(ftpIp + ":8080/img/storyteller/user/" + fileUUID);
//
//            try {
//                uploadService.generateThumbnail(videoFilePath, thumbnailFilePath);
//                String time = uploadService.getVideoDuration(videoFilePath);// 재생시간
//                System.out.println("재생시간: " + time);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

        }else{
            userDto.setProfileUrl("null");
        }



        userService.modifyUser(userDto);


        return "redirect:/admin/users";
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
        List<LectureDto> list = lectureService.findLectureListAll();
        model.addAttribute("lists", list);
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
     * 교재관리
     */
    @PostMapping("/lecture-write")
    public String adminLecturePostWrite(@RequestParam("files") MultipartFile files, LectureDto lectureDto) {

        if (!files.isEmpty()) {
            String fileUUID = uploadService.uploadFileToServer(files, "/var/lib/tomcat9/webapps/img/storyteller/lecture");
            lectureDto.setVideoUrl(ftpIp + ":8080/img/storyteller/lecture/" + fileUUID);

            String videoFilePath = "C:\\file\\test.mp4"; // 동영상 파일 경로
            String thumbnailFilePath = "C:\\file\\thumbnail.jpg"; // 썸네일 저장 경로

            //String videoFilePath = "/var/lib/tomcat9/webapps/img/storyteller/user/" + fileUUID;
            //String thumbnailFilePath = "/var/lib/tomcat9/webapps/img/storyteller/user/thumbnail/thumbnail_" + fileUUID;

            lectureDto.setThumbnailUrl(ftpIp + ":8080/img/storyteller/lecture/thumbnail/thumbnail_" + removeExtension(fileUUID)+".jpg");

            try {
                uploadService.generateThumbnail(videoFilePath, thumbnailFilePath);
                String time = uploadService.getVideoDuration(videoFilePath);// 재생시간
                lectureDto.setWatchingTile(time);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        lectureService.createLecture(lectureDto);


        return "redirect:/admin/lecture";
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
     * 모의고사 과목 등록
     */
    @PostMapping("/examination-write")
    public String adminExaminationPostWrite(ExaminationDto examinationDto, Model model) {
        examinationService.createExaminationMajor(examinationDto);
        return "redirect:/admin/examination";
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
     * 모의고사 챕터 등록
     */
    @PostMapping("/examination2-write")
    public String adminExamination2PostWrite(ExaminationDto examinationDto, Model model) {
        examinationService.createExaminationChapter(examinationDto);
        return "redirect:/admin/examination2/" + examinationDto.getExaminationMajorIdx();
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
     * 문제목록
     */
    @GetMapping("/question-write/{examinationChapterIdx}")
    public String adminQuestionWrite(@PathVariable int examinationChapterIdx, Model model) {
        model.addAttribute("examinationChapterIdx", examinationChapterIdx);
        return "admin/questionWrite";
    }

    /**
     * 문제목록
     */
    @GetMapping("/question-edit/{examinationIdx}")
    public String adminQuestionEdit(@PathVariable int examinationIdx, Model model) {
        ExaminationDto detail = examinationService.findExaminationByExaminationIdx(examinationIdx);
        List<ExaminationDto> list = examinationService.findexaminationSelectByExaminationIdx(examinationIdx);

        model.addAttribute("detail", detail);
        model.addAttribute("lists", list);

        return "admin/questionEdit";
    }

    /**
     * 문제목록
     */
    @PostMapping("/question-edit")
    public String adminQuestionPostEdit(@RequestParam("selectTitle") String[] titles, ExaminationDto examinationDto, Model model) {

        examinationService.deleteExaminationSelectByExaminationIdx(examinationDto.getExaminationIdx());
        examinationService.modifyExamination(examinationDto);

        for(int i = 0; i < titles.length; i++){
            examinationDto.setExaminationSelectTitle(titles[i]);
            examinationDto.setExaminationSelectNum(i+1);
            examinationDto.setExaminationIdx(examinationDto.getExaminationIdx());
            examinationService.createExaminationSelect(examinationDto);
        }


        return "redirect:/admin/question/" + examinationDto.getExaminationChapterIdx();
    }

    /**
     * 문제목록
     */
    @PostMapping("/question-write")
    public String adminQuestionPostWrite(@RequestParam("selectTitle") String[] titles, ExaminationDto examinationDto, Model model) {
        examinationService.createExamination(examinationDto);

        for(int i = 0; i < titles.length; i++){
            examinationDto.setExaminationSelectTitle(titles[i]);
            examinationDto.setExaminationSelectNum(i+1);
            examinationDto.setExaminationIdx(examinationDto.getExaminationIdx());
            examinationService.createExaminationSelect(examinationDto);
        }
        return "redirect:/admin/question/" + examinationDto.getExaminationChapterIdx();
    }

    /**
     * 문제목록
     */
    @GetMapping("/question/{examinationChapterIdx}")
    public String adminQuestion(@PathVariable int examinationChapterIdx, Model model) {
        List<ExaminationDto> list = examinationService.findExaminationByChapter(examinationChapterIdx);
        model.addAttribute("lists", list);
        return "admin/question";
    }



    /**
     * 교재관리
     */
    @GetMapping("/score")
    public String adminScore(Model model) {
        return "admin/score";
    }



    @GetMapping("/attendance")
    public String adminAttendance(@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                  @RequestParam(required = false) String type, Model model) {

        LocalDate today = (date != null) ? date : LocalDate.now();

        if ("before".equals(type)) {
            today = today.minusDays(1);
        } else if ("after".equals(type)) {
            today = today.plusDays(1);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = today.format(formatter);

        model.addAttribute("today", formattedDate);


        List<AttendanceDto> list = attendanceService.findAttendanceByAll(formattedDate);
        model.addAttribute("lists", list);


        return "admin/attendance";
    }

    @GetMapping("/attendance/{idx}/{result}/{today}")
    public String adminAttendanceUpdate(@PathVariable int idx, @PathVariable String result, @PathVariable String today, AttendanceDto attendanceDto) {

        attendanceDto.setUserIdx(idx);
        attendanceDto.setResult(result);

        attendanceDto.setCreatedAt(today.substring(0,10));
        List<AttendanceDto> list = attendanceService.findAttendanceByIdxAndDate(attendanceDto);

        if(list.isEmpty()){
            attendanceDto.setCreatedAt(today);
            attendanceService.attendanceInsert(attendanceDto);
        }else {
            attendanceDto.setCreatedAt(today);
            attendanceDto.setAttendanceIdx(list.get(0).getAttendanceIdx());
            attendanceService.attendanceModify(attendanceDto);
        }


        return "redirect:/admin/attendance?date="+today.substring(0,10);
    }

    public static String removeExtension(String filename) {
        if (filename == null) return null;
        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == -1) return filename; // 확장자가 없는 경우

        return filename.substring(0, lastDotIndex);
    }
}
