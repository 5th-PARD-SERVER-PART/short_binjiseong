package com.pard.practice_tomorrow.post.dto;

import com.pard.practice_tomorrow.post.entity.Post;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

public class PostResDto {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReadPost{
        private Long postId;
        private String title;
        private String content;
    }
    public static List<ReadPost> postToDto(List<Post> posts) {
        List<ReadPost> prr = new ArrayList<>();
        for(Post post : posts){
            ReadPost readPost = new ReadPost(post.getPostId(), post.getContent(), post.getTitle());
            prr.add(readPost);
        }
        return prr;
    }
}
