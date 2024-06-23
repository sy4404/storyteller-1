package com.luxury.storyteller.web;

import com.luxury.storyteller.config.auth.PrincipalDetails;
import com.luxury.storyteller.dto.AttendanceDto;
import com.luxury.storyteller.service.attendance.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;
//    /**
//     * 출결
//     */
//    @GetMapping("")
//    public String score() {
//
//        return "attendance/list";
//    }


    @GetMapping("")
    public String attendancef(@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                              @RequestParam(required = false) String type, Model model,
                              @AuthenticationPrincipal PrincipalDetails principalDetails,
                              AttendanceDto attendanceDto) {

        LocalDate today = (date != null) ? date : LocalDate.now();

        if ("before".equals(type)) {
            today = today.minusMonths(1);
        } else if ("after".equals(type)) {
            today = today.plusMonths(1);
        }


        DateTimeFormatter formatterY = DateTimeFormatter.ofPattern("yyyy");
        System.out.println(today.format(formatterY));
        attendanceDto.setYear(today.format(formatterY));

        DateTimeFormatter formatterM = DateTimeFormatter.ofPattern("MM");
        System.out.println(today.format(formatterM));
        attendanceDto.setMonth(today.format(formatterM));
        attendanceDto.setUserIdx(principalDetails.getUserIdx());

        List<AttendanceDto> list = attendanceService.findAttendanceByUserIdx(attendanceDto);

        System.out.println(list.size());

        model.addAttribute("lists", list);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String formattedDate = today.format(formatter);

        model.addAttribute("today", formattedDate);

//        // 예를 들어, 출석 데이터를 조회하거나 필요한 처리를 여기에 추가합니다.
//        List<AttendanceDto> list = attendanceService.findAttendanceByAll(formattedDate);
//        model.addAttribute("lists", list);


        return "attendance/list";
    }


}
