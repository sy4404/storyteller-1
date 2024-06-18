package com.luxury.storyteller.dto;

import lombok.Data;

@Data
public class AttendanceDto {
    private int attendanceIdx;
    private String result;
    private String createdAt;

    private int userIdx;
    private String id;
    private String name;
    private String phoneNumber;
    private String profileUrl;
}
