package com.pard.hw4.post.controller;

import com.pard.hw4.post.dto.RequestPostDto;
import com.pard.hw4.post.dto.ResponsePostDto;
import com.pard.hw4.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping("/{userId}")
    public String CreatePost(@PathVariable Long userId,@RequestBody RequestPostDto.PostCreateRequest req){
        postService.createPost(userId,req);
        return("글 저장 성공!");
    }
    @GetMapping("/{userId}")
    public List<ResponsePostDto.PostingReadResponse> readByUserId(@PathVariable Long userId){
        return postService.findByUserId(userId);
    }
    @PatchMapping("/{postId}")
    public String update(@PathVariable Long postId, @RequestBody RequestPostDto.PostCreateRequest postDto){
        postService.update(postId,postDto);
        return "수정완료!";
    }
    @DeleteMapping("/{postId}")
    public String delete(@PathVariable Long postId){
        postService.delete(postId);
        return "삭제완료";
    }
}
