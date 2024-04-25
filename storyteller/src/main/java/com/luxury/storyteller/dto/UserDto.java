package com.luxury.storyteller.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDto {
    private int userIdx;
    private String id;
    private String password;
    private String name;
    private String phoneNumber;
    private int personalInfo;
    private int termsCondition;
    private String profileUrl;
    private String role;
}
