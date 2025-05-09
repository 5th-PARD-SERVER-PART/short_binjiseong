package com.pard.hw5.likes.controller;

import com.pard.hw5.likes.dto.LikeResDto;
import com.pard.hw5.likes.service.LikeService;
import com.pard.hw5.member.security.CustomOAuth2User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/like")
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/toggle/{postId}")
    public ResponseEntity<LikeResDto> toggleLike(@AuthenticationPrincipal CustomOAuth2User user, @PathVariable Long postId){
        Long userId = user.getMember().getId();
        boolean liked = likeService.toggleLike(userId,postId);
        return ResponseEntity.ok(new LikeResDto(liked));
    }
}
