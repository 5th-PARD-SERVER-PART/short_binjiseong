package com.pard.practice_tomorrow.like.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LikeResDto {
    private String message;

    public LikeResDto(boolean liked){
        this.message = liked ? "Liked" : "Unliked";
    }

    public String getMessage(){
        return message;
    }
}
