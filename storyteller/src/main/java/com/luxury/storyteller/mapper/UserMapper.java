package com.luxury.storyteller.mapper;

import com.luxury.storyteller.dto.user.UserRequestDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int createUser(UserRequestDto joinRequestDto);
}
