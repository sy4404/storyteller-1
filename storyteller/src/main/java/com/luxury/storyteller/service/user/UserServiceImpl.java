package com.luxury.storyteller.service.user;

import com.luxury.storyteller.dto.UserDto;
import com.luxury.storyteller.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public int createUser(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userMapper.createUser(userDto);
        return 0;
    }

    @Override
    public UserDto findUserByUserIdx(int userIdx) {
        return userMapper.findUserByUserIdx(userIdx);
    }

    @Override
    public int modifyUser(UserDto userDto) {
        //userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userMapper.modifyUser(userDto);
    }

    @Override
    public int userModifyUser(UserDto userDto) {
        return userMapper.userModifyUser(userDto);
    }

    @Override
    public UserDto findUserByIdAndPhoneNumber(UserDto userDto) {
        return userMapper.findUserByIdAndPhoneNumber(userDto);
    }

    @Override
    public UserDto findUserById(String id) {
        return userMapper.findUserById(id);
    }

    @Override
    public List<UserDto> findByUserAll() {
        return userMapper.findByUserAll();
    }

    @Override
    public List<UserDto> isDuplicateId(String id) {
        return userMapper.isDuplicateId(id);
    }

    @Override
    public int pwdModify(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userMapper.pwdModify(userDto);
    }

    @Override
    public UserDto findUserByIdAndPhoneNumbeAndName(UserDto userDto) {
        return userMapper.findUserByIdAndPhoneNumbeAndName(userDto);
    }

}
