package com.pard.hw5.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pard.hw5.post.entity.Post;
import com.pard.hw5.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


public class RequestUserDto {//request 중 읽는거,생성하는 거 두개 구분
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UserReadRequest{//읽는 request
        private Long userId;
        private String userName;
        private List<Post> posts;

        public static UserReadRequest from(User u){
            return new UserReadRequest(u.getUserId(),u.getUserName(),u.getPosts());
        }
    }
    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserCreateRequest{//생성하는 reqeust
        private String userName;
    }

}
