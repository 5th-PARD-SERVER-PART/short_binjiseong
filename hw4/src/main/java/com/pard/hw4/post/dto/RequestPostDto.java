package com.pard.hw4.post.dto;

import lombok.*;

import java.sql.Timestamp;



public class RequestPostDto {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder

    public static class PostCreateRequest{
        private String title;
        private String content;
        private Timestamp date;
    }

}
