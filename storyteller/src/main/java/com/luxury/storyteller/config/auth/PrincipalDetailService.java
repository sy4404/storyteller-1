package com.luxury.storyteller.config.auth;

import com.luxury.storyteller.dto.UserDto;
import com.luxury.storyteller.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class PrincipalDetailService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = userService.findUserById(username);
        if(user != null){
            return new PrincipalDetails(user);
        }
        return null;
    }
}
