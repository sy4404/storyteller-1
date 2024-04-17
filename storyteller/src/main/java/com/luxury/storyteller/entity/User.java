package com.luxury.storyteller.entity;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    private int userIdx;
    private String id;
    private String password;
    private String name;
    private String phoneNumber;
    private int personalInfo;
    private int termsCondition;
    private String profileUrl;
}
