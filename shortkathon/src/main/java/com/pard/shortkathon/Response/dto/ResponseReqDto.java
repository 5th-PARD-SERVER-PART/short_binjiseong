package com.pard.shortkathon.Response.dto;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseReqDto {
    private Long userId;
    private List<Answer> answers;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Answer {
        private Long questionId;
        private String userAnswer;
    }
}
