package com.luxury.storyteller.service.user;

import com.luxury.storyteller.dto.UserDto;
import com.luxury.storyteller.dto.user.UserRequestDto;

public interface UserService {
    int createUser(UserRequestDto joinRequestDto);

    UserDto findUserByUserIdx(int userIdx);

    int modifyUser(UserDto userDto);
}
