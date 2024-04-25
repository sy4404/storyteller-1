package com.luxury.storyteller.config.auth;

import com.luxury.storyteller.dto.UserDto;
import com.luxury.storyteller.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


//login 요청이 오면 PrincipalDetailService 타입으로 ioc 되어있는 loadUserByUsername 함수가 실행
@Service
public class PrincipalDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = userService.findUserById(username);
        if(user != null){
            return new PrincipalDetails(user);
        }
        return null;
    }
}
