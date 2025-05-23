package com.pard.practice_tomorrow.config;

import com.pard.practice_tomorrow.member.service.PrincipalOauth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final PrincipalOauth2UserService principalOauth2UserService;

    private final CorsConfig corsConfig;

    @Bean
    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception{

        http.csrf(AbstractHttpConfigurer::disable);

        http.addFilter(corsConfig.corsFilter());//수많은 filter로 이루어져있음

        http.authorizeHttpRequests(au -> au.anyRequest().permitAll());//요청 다 허용

        http.oauth2Login(
                oauth -> oauth
                        .loginPage("/loginForm")
                        .defaultSuccessUrl("/home")
                        .userInfoEndpoint(
                                userInfo -> userInfo.userService(principalOauth2UserService)//유저정보를 안에 들어있는 함수를 통해서 넣는다는 의미
                        )
        );
        return http.build();
    }
}
