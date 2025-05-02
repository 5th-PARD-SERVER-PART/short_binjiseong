package com.pard.hw4.user.dto;

import com.pard.hw4.post.dto.ResponsePostDto;
import com.pard.hw4.user.entity.User;
import lombok.*;

import java.util.List;

public class ResponseUserDto {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReadUser{
        private String userName;
        private List<ResponsePostDto.PostingReadResponse> posts;

        public static ReadUser from(User user){
            return new ReadUser(user.getUserName(),
                    ResponsePostDto.PostingReadResponse.postingToDto(
                    user.getPosts()));
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReadAllUser{
        private Long userId;
        private String userName;

        public static ReadAllUser from(User user) {
            return new ReadAllUser(user.getUserId(), user.getUserName());
        }
    }

}