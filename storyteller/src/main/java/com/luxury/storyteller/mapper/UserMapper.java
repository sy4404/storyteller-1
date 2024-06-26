package com.luxury.storyteller.mapper;

import com.luxury.storyteller.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int createUser(UserDto userDto);
    UserDto findUserByUserIdx(int userIdx);
    int modifyUser(UserDto userDto);
    UserDto findUserByIdAndPhoneNumber(UserDto userDto);
    UserDto findUserById(String id);

    /**
     * 회원 목록
     */
    List<UserDto> findByUserAll();

    List<UserDto> isDuplicateId(String id);

    int userModifyUser(UserDto userDto);

    /**
     * 비밀번호변경
     */
    int pwdModify(UserDto userDto);

    UserDto findUserByIdAndPhoneNumbeAndName(UserDto userDto);

}
