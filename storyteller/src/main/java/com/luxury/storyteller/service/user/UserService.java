package com.luxury.storyteller.service.user;

import com.luxury.storyteller.dto.user.JoinRequestDto;

public interface UserService {
    int createUser(JoinRequestDto joinRequestDto);
}
