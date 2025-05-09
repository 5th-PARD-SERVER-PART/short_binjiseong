package com.pard.hw5.post.controller;

import com.pard.hw5.member.security.CustomOAuth2User;
import com.pard.hw5.post.dto.RequestPostDto;
import com.pard.hw5.post.dto.ResponsePostDto;
import com.pard.hw5.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping("")
    public String CreatePost(@AuthenticationPrincipal CustomOAuth2User user, @RequestBody RequestPostDto.PostCreateRequest req){
        Long userId = user.getMember().getId();
        postService.createPost(userId,req);
        return("글 저장 성공!");
    }
    @GetMapping("")
    public List<ResponsePostDto.PostingReadResponse> readByUserId(@AuthenticationPrincipal CustomOAuth2User user){
        Long userId = user.getMember().getId();
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
