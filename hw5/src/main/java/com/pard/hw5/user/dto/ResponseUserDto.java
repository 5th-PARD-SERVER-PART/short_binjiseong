package com.pard.hw5.user.dto;

import com.pard.hw5.post.dto.ResponsePostDto;
import com.pard.hw5.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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