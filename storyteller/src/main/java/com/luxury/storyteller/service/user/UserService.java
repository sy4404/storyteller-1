package com.luxury.storyteller.service.user;

import com.luxury.storyteller.dto.UserDto;

import java.util.List;

public interface UserService {
    /**
     * 회원 등록
     */
    int createUser(UserDto userDto);

    /**
     * 해당 회원 정보 조회
     */
    UserDto findUserByUserIdx(int userIdx);

    /**
     * 해당 회원 정보 수정
     */
    int modifyUser(UserDto userDto);

    /**
     * 해당 회원 정보 수정
     */
    int userModifyUser(UserDto userDto);

    /**
     * 아이디, 휴대폰번호로 아이디찾기
     */
    UserDto findUserByIdAndPhoneNumber(UserDto userDto);

    /**
     * 아이디로 조회
     */
    UserDto findUserById(String id);

    /**
     * 회원 목록
     */
    List<UserDto> findByUserAll();

    List<UserDto> isDuplicateId(String id);

    /**
     * 비밀번호변경
     */
    int pwdModify(UserDto userDto);

    UserDto findUserByIdAndPhoneNumbeAndName(UserDto userDto);
}
