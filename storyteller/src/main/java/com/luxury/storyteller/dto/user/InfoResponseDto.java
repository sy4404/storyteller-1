package com.luxury.storyteller.dto.user;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class InfoResponseDto {
    private int userIdx;
    private String id;
    private String phoneNumber;
}
