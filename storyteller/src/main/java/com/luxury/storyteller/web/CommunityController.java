package com.luxury.storyteller.web;

import com.luxury.storyteller.config.auth.PrincipalDetails;
import com.luxury.storyteller.dto.CommentDto;
import com.luxury.storyteller.dto.CommunityDto;
import com.luxury.storyteller.dto.CommunityImgDto;
import com.luxury.storyteller.service.UploadService;
import com.luxury.storyteller.service.community.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/community")
public class CommunityController {

    private final CommunityService communityService;
    private final UploadService uploadService;

    @Value("${ftp.ip}")
    protected String ftpIp;
    /**
     * 공지사항 목록 페이지
     */
    @GetMapping("/notice")
    public String communityNoticePage(Model model) {

        List<CommunityDto> list = communityService.findCommunityListAll();
        model.addAttribute("lists", list);

        return "community/noticeList";
    }

    /**
     * 공지사항 상세 페이지
     */
    @GetMapping("/notice/{communityIdx}")
    public String communityNoticeInfoPage(@PathVariable int communityIdx, Model model) {

        CommunityDto detail = communityService.findCommunityByCommunityIdx(communityIdx);
        model.addAttribute("dedail", detail);

        List<CommentDto> list = communityService.findCommunityCommentByCommunityIdx(communityIdx);
        model.addAttribute("lists", list);
        model.addAttribute("commentCount", list.size());

        return "community/noticeInfo";
    }

    /**
     * QnA 목록 페이지
     */
    @GetMapping("/qna")
    public String communityQnaPage(Model model) {

        List<CommunityDto> list = communityService.findCommunityQnAListAll();
        model.addAttribute("lists", list);

        return "community/qnaList";
    }

    /**
     * QnA 상세 페이지
     */
    @GetMapping("/qna/{communityIdx}")
    public String communityQnaInfoPage(@PathVariable int communityIdx, Model model) {

        CommunityDto detail = communityService.findCommunityByCommunityIdx(communityIdx);
        model.addAttribute("dedail", detail);

        List<CommentDto> list = communityService.findCommunityCommentByCommunityIdx(communityIdx);
        model.addAttribute("lists", list);
        model.addAttribute("commentCount", list.size());

        return "community/qnaInfo";
    }

    @GetMapping("/qna-write")
    public String communityQnaWrite(Model model) {


        return "community/qnaWrite";
    }

    @PostMapping("/qna-write")
    public String communityQnaPostWrite(@RequestParam("files") MultipartFile[] files,
                                        CommunityDto communityDto,
                                        @AuthenticationPrincipal PrincipalDetails principalDetails,
                                        Model model, CommunityImgDto communityImgDto) {

        communityDto.setUserIdx(principalDetails.getUserIdx());
        communityService.createQna(communityDto);

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                String fileUUID = uploadService.uploadFileToServer(file, "/var/lib/tomcat9/webapps/img/storyteller/community");
                communityImgDto.setCommunityIdx(communityDto.getCommunityIdx());
                communityImgDto.setImageUrl(ftpIp + ":8080/img/storyteller/community/" + fileUUID);
                communityService.createImgQna(communityImgDto);
            }
        }

        return "redirect:/community/qna";
    }

    @PostMapping("/notice-comment-write")
    public String noticeCommentWrite(CommentDto commentDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        commentDto.setUserIdx(principalDetails.getUserIdx());
        communityService.createComment(commentDto);

        return "redirect:/community/notice/"+ commentDto.getCommunityIdx();
    }


}
