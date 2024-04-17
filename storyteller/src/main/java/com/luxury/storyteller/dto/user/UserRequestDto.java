package com.luxury.storyteller.dto.user;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserRequestDto {
    private int userIdx;
    private String id;
    private String password;
    private String name;
    private String phoneNumber;
    private int personalInfo;
    private int termsCondition;
    private String profileUrl;
}
