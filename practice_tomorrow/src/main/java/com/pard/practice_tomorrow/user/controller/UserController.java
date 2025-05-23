package com.pard.practice_tomorrow.user.controller;

import com.pard.practice_tomorrow.post.dto.PostResDto;
import com.pard.practice_tomorrow.user.dto.UserReqDto;
import com.pard.practice_tomorrow.user.dto.UserResDto;
import com.pard.practice_tomorrow.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    //간단한 user CRUD
    @PostMapping("")
    public String createUser(@RequestBody UserReqDto.UserCreateUpdate req){
        userService.createUser(req);
        return "저장 성공";
    }
    @GetMapping("")
    public List<UserResDto.ReadUser> readUsers(){
        return userService.readUsers();
    }
    @GetMapping("/{Id}")
    public List<UserResDto.ReadPostByUserId> readPostByUserId(@PathVariable Long Id){
        return userService.readPostByUserId(Id);
    }
    @PatchMapping("/{Id}")
    public String updateById(@PathVariable Long Id, @RequestBody UserReqDto.UserCreateUpdate req){
        userService.updateById(Id, req);
        return "입력한 "+Id+"번 내용 수정완료!";
    }
    @DeleteMapping("/{Id}")
    public String deleteById(@PathVariable Long Id){
        userService.deleteById(Id);
        return "입력한 "+Id+"번 내용 삭제완료!";
    }

}
