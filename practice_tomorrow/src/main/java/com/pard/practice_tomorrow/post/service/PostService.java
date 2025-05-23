package com.pard.practice_tomorrow.post.service;


import com.pard.practice_tomorrow.post.dto.PostReqDto;
import com.pard.practice_tomorrow.post.dto.PostResDto;
import com.pard.practice_tomorrow.post.entity.Post;
import com.pard.practice_tomorrow.post.repo.PostRepo;
import com.pard.practice_tomorrow.user.entity.User;
import com.pard.practice_tomorrow.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final UserRepo userRepo;
    private final PostRepo postRepo;

    public void createPost(Long userId, PostReqDto.PostCreateUpdate req){
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. ID: " + userId));

            Post post = Post.builder()
                    .title(req.getTitle())
                    .content(req.getContent())
                    .user(user)
                    .build();
            postRepo.save(post);
    }
    public List<PostResDto.ReadPost> findByUserId(Long userId) {
        List<Post> posts = postRepo.findAllByUser_UserId(userId);
        return PostResDto.postToDto(posts);
    }
    @Transactional
    public void update(Long postId,PostReqDto.PostCreateUpdate req){
        Post post = postRepo.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. ID: " + postId));

        post.update(req);
        postRepo.save(post);
    }
    @Transactional
    public void delete(Long postId){
        Post post = postRepo.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. ID: " + postId));
        postRepo.delete(post);
    }
}
