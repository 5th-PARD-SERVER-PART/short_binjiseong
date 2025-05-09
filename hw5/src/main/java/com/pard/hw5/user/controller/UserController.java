package com.pard.hw5.user.controller;

import com.pard.hw5.member.security.CustomOAuth2User;
import com.pard.hw5.user.dto.RequestUserDto;
import com.pard.hw5.user.dto.ResponseUserDto;
import com.pard.hw5.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController{
    private final UserService userService;
    @GetMapping("/all")
    public List<ResponseUserDto.ReadAllUser> readAll() {
        return userService.readAll();
    }
    @GetMapping("")
    public ResponseUserDto.ReadUser readUser(@AuthenticationPrincipal CustomOAuth2User user){
        Long userId = user.getMember().getId();
        return userService.readUser(userId);
    }
    @PostMapping("")
    public String createUser (@RequestBody RequestUserDto.UserCreateRequest req){
        userService.createUser(req);
        return("사용자 저장 성공!");
    }
    @DeleteMapping("")
    public void deleteUser(@AuthenticationPrincipal CustomOAuth2User user){
        Long userId = user.getMember().getId();
        userService.deleteUser(userId);
    }

}
