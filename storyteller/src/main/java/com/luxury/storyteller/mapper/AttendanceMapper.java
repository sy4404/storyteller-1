package com.luxury.storyteller.mapper;

import com.luxury.storyteller.dto.AttendanceDto;
import com.luxury.storyteller.dto.CommentDto;
import com.luxury.storyteller.dto.CommunityDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttendanceMapper {
    /**
     * 전체 사용자 출석
     */
    List<AttendanceDto> findAttendanceByAll(String date);

    int attendanceInsert(AttendanceDto attendanceDto);
}
