package com.luxury.storyteller.service.attendance;

import com.luxury.storyteller.dto.AttendanceDto;
import com.luxury.storyteller.dto.CommentDto;
import com.luxury.storyteller.dto.CommunityDto;
import com.luxury.storyteller.mapper.AttendanceMapper;
import com.luxury.storyteller.mapper.CommunityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceMapper attendanceMapper;

    @Override
    public List<AttendanceDto> findAttendanceByAll(String date) {
        return attendanceMapper.findAttendanceByAll(date);
    }

    @Override
    public int attendanceInsert(AttendanceDto attendanceDto) {
        return attendanceMapper.attendanceInsert(attendanceDto);
    }

    @Override
    public List<AttendanceDto> findAttendanceByIdxAndDate(AttendanceDto attendanceDto) {
        return attendanceMapper.findAttendanceByIdxAndDate(attendanceDto);
    }

    @Override
    public int attendanceModify(AttendanceDto attendanceDto) {
        return attendanceMapper.attendanceModify(attendanceDto);
    }

    @Override
    public List<AttendanceDto> findAttendanceByUserIdx(AttendanceDto attendanceDto) {
        return attendanceMapper.findAttendanceByUserIdx(attendanceDto);
    }
}
