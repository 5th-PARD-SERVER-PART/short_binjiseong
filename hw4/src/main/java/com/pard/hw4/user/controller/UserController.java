package com.pard.hw4.user.controller;

import com.pard.hw4.post.dto.ResponsePostDto;
import com.pard.hw4.user.dto.RequestUserDto;
import com.pard.hw4.user.dto.ResponseUserDto;
import com.pard.hw4.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController{
    private final UserService userService;
    @GetMapping("")
    public List<ResponseUserDto.ReadAllUser> readAll() {
        return userService.readAll();
    }
    @GetMapping("/{userId}")
    public ResponseUserDto.ReadUser readUser(@PathVariable Long userId){
        return userService.readUser(userId);
    }
    @PostMapping("")
    public String createUser (@RequestBody RequestUserDto.UserCreateRequest req){
        userService.createUser(req);
        return("사용자 저장 성공!");
    }
    @DeleteMapping("/{Id}")
    public void deleteUser(@PathVariable Long Id){
        userService.deleteUser(Id);
    }

}
