package com.pard.seminar2.user.controller;

import com.pard.seminar2.user.dto.UserDto;
import com.pard.seminar2.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor//생성자 final
@RequestMapping("/user")
public class UserController {
    private final UserService userService;//final붙이는 이유 -> postService라고 쓰면 오류찾기 힘듬

    @PostMapping("")
    public String save (@RequestBody UserDto userDto) {//요청 Dto를 사용하려면 @RequestBody를 써야 함,jason을 알아서 처리해서 dto로 넣어줌,http json으로 주고받음
        userService.saveUser(userDto);
        return "저장완료~~";
    }
    @GetMapping("/{studentID}")
    public UserDto findByID(@PathVariable Long studentID) {//id를 받았을 때 dto형식으로 줄려고
        return userService.findByID(studentID);
    }
    @PatchMapping("/{studentID}")
    public String updateByID (@PathVariable Long studentID, @RequestBody UserDto userDto) {
        userService.updateByID(studentID,userDto);
        return "수정완료~";
    }
    @DeleteMapping("{studentID}")
    public String delete(@PathVariable Long studentID) {
        userService.delete(studentID);
        return "삭제완료~";
    }
    @GetMapping("")
    public List<UserDto> findAll() {//java util로
        return userService.findAll();
    }
}
