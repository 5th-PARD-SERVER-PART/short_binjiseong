package com.pard.seminar6.user.controller;

import com.pard.seminar6.user.dto.UserReqDto;
import com.pard.seminar6.user.dto.UserResDto;
import com.pard.seminar6.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("")//저장
    public String save(@RequestBody UserReqDto UserReqDto){
        userService.save(UserReqDto);
        return "저장완료";
    }
//    @GetMapping("")//모든 리스트 보기
//    public List<UserResDto> readAll(){
//        return userService.readAll();
//    }
    @GetMapping("")//들어온 순서대로 id가 자동생성 되고 이 id로 찾기
    public List<UserResDto> readByPart(@RequestParam String part){
        return userService.readByPart(part);
    }
    @PatchMapping("/{Id}")
    public String updateById(@PathVariable int Id, @RequestBody UserReqDto UserReqDto){
        userService.updateById(Id, UserReqDto);
        return "입력한 "+Id+"번 내용 수정완료!";
    }
    @DeleteMapping("/{Id}")
    public String deleteById(@PathVariable int Id){
        userService.deleteById(Id);
        return "입력한 "+Id+"번 내용 삭제완료!";
    }
}
