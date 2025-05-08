package com.pard.hw4.likes.controller;

import com.pard.hw4.likes.dto.LikeResDto;
import com.pard.hw4.likes.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/like")
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/toggle/{userId}/{postId}")
    public ResponseEntity<LikeResDto> toggleLike(@PathVariable Long userId,@PathVariable Long postId){
        boolean liked = likeService.toggleLike(userId,postId);
        return ResponseEntity.ok(new LikeResDto(liked));
    }
}
