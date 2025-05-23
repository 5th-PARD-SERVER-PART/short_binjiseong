package com.pard.practice_tomorrow.like.controller;


import com.pard.practice_tomorrow.like.dto.LikeResDto;
import com.pard.practice_tomorrow.like.service.LikeService;
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
    public ResponseEntity<LikeResDto> toggleLike(@PathVariable Long userId, @PathVariable Long postId){
        boolean liked = likeService.toggleLike(userId,postId);
        return ResponseEntity.ok(new LikeResDto(liked));
    }
}
