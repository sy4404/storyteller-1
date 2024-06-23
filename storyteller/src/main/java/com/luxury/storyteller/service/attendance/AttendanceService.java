package com.luxury.storyteller.service.attendance;

import com.luxury.storyteller.dto.AttendanceDto;
import com.luxury.storyteller.dto.CommentDto;
import com.luxury.storyteller.dto.CommunityDto;

import java.util.List;

public interface AttendanceService {
    /**
     * 전체 사용자 출석
     */
    List<AttendanceDto> findAttendanceByAll(String date);

    int attendanceInsert(AttendanceDto attendanceDto);

    List<AttendanceDto> findAttendanceByIdxAndDate(AttendanceDto attendanceDto);

    int attendanceModify(AttendanceDto attendanceDto);

    List<AttendanceDto> findAttendanceByUserIdx(AttendanceDto attendanceDto);

}
