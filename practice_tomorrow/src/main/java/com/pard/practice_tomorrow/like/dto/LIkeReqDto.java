package com.pard.practice_tomorrow.like.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LIkeReqDto {
    private Long userId;
    private Long postId;
}
