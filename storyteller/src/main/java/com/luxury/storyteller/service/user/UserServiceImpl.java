package com.luxury.storyteller.service.user;

import com.luxury.storyteller.dto.UserDto;
import com.luxury.storyteller.dto.user.UserRequestDto;
import com.luxury.storyteller.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public int createUser(UserRequestDto joinRequestDto) {
        joinRequestDto.setPassword(passwordEncoder.encode(joinRequestDto.getPassword()));
        userMapper.createUser(joinRequestDto);
        return 0;
    }

    @Override
    public UserDto findUserByUserIdx(int userIdx) {
        return userMapper.findUserByUserIdx(userIdx);
    }

    @Override
    public int modifyUser(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userMapper.modifyUser(userDto);
    }
}
