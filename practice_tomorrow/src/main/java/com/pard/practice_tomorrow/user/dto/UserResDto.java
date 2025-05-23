package com.pard.practice_tomorrow.user.dto;

import com.pard.practice_tomorrow.post.dto.PostResDto;
import com.pard.practice_tomorrow.post.entity.Post;
import com.pard.practice_tomorrow.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


public class UserResDto {
    //user 생성,수정 보여줄때 사용
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ReadUser{
        private Long userId;
        private String userName;

        public static ReadUser from(User user){
            return new ReadUser(user.getUserId(), user.getUserName());
        }
    }
    //user가 쓴 글을 모두 보고 싶으면 -> 나중에 구현
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ReadPostByUserId{
        private Long userId;
        private List<PostResDto.ReadPost> posts;

        public static ReadPostByUserId from(User user){
            return new ReadPostByUserId(user.getUserId(),PostResDto.postToDto(user.getPosts()));
        }
    }

}
