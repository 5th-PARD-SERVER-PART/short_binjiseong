package com.pard.practice_tomorrow.post.dto;

import lombok.*;

public class PostReqDto {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PostCreateUpdate{
        private String title;
        private String content;
    }
}
