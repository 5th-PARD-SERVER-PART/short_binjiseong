package com.pard.practice_tomorrow.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



public class UserReqDto {
    //user 생성 요청
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UserCreateUpdate{
        String userName;
    }
}
