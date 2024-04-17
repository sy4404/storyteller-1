package com.luxury.storyteller.dto.user;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@ToString
public class JoinRequestDto {
    private int userIdx;
    private String id;
    private String password;
    private String name;
    private String phoneNumber;
    private int personalInfo;
    private int termsCondition;
    private String profileUrl;
}
