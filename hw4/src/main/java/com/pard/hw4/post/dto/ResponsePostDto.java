package com.pard.hw4.post.dto;

import com.pard.hw4.post.entity.Post;
import lombok.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class ResponsePostDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PostingReadResponse{
        private Long postId;
        private String Title;
        private String content;
        private Timestamp date;

        public static List<PostingReadResponse> postingToDto(List<Post> posts){
            List<PostingReadResponse> prr = new ArrayList<>();
            for(Post post : posts){
                PostingReadResponse p=
                new PostingReadResponse(post.getPostId(),post.getTitle(),post.getContent(),post.getDate());
                prr.add(p);
            }
            return prr;
        }
    }
}
