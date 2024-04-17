package com.luxury.storyteller.mapper;

import com.luxury.storyteller.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int createUser(UserDto userDto);
    UserDto findUserByUserIdx(int userIdx);
    int modifyUser(UserDto userDto);
    UserDto findUserByIdAndPhoneNumber(UserDto userDto);
}
