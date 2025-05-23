package com.pard.practice_tomorrow.post.controller;


import com.pard.practice_tomorrow.post.dto.PostReqDto;
import com.pard.practice_tomorrow.post.dto.PostResDto;
import com.pard.practice_tomorrow.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping("/{userId}")
    public String CreatePost(@PathVariable Long userId, @RequestBody PostReqDto.PostCreateUpdate req){
        postService.createPost(userId,req);
        return("글 저장 성공!");
    }
    //한 유저가 쓴 모든 글을 읽고 싶을 때
    @GetMapping("/{userId}")
    public List<PostResDto.ReadPost> readByUserId(@PathVariable Long userId){
        return postService.findByUserId(userId);
    }
    @PatchMapping("/{postId}")
    public String update(@PathVariable Long postId, @RequestBody PostReqDto.PostCreateUpdate req){
        postService.update(postId,req);
        return "수정완료!";
    }
    @DeleteMapping("/{postId}")
    public String delete(@PathVariable Long postId){
        postService.delete(postId);
        return "삭제완료";
    }
}
