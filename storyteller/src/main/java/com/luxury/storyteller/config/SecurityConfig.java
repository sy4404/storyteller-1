package com.luxury.storyteller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
//                .antMatchers("/login","/admin/login").permitAll()
//                .antMatchers("/admin/img/**","/admin/css/**", "/admin/js/**", "/admin/vendor/**").permitAll()
//                .antMatchers("/user/**").authenticated()
//                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()
                .and()
            .formLogin()
                .usernameParameter("id")
                .passwordParameter("password")
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error");
//                .and()
//            .formLogin()
//                .loginPage("/admin/login")
//                .loginProcessingUrl("/admin/login")
//                .usernameParameter("adminId")
//                .passwordParameter("adminPassword")
//                .defaultSuccessUrl("/admin")
//                .failureUrl("/admin/login?error");
        return http.build();
    }
}
