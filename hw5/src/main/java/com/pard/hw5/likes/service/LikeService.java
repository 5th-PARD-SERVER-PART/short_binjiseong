package com.pard.hw5.likes.service;

import com.pard.hw5.likes.entity.Likes;
import com.pard.hw5.likes.repo.LikeRepo;
import com.pard.hw5.post.entity.Post;
import com.pard.hw5.post.repo.PostRepository;
import com.pard.hw5.user.entity.User;
import com.pard.hw5.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepo likeRepo;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public boolean toggleLike(Long userId, Long postId){
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));

        Post post = postRepository.findById(postId).orElseThrow(()->new RuntimeException("Post not found"));

        Optional<Likes> existingLike = likeRepo.findByUserAndPost(user,post);

        if(existingLike.isPresent()){
            Likes like = existingLike.get();
            like.toggle();
            likeRepo.save(like);
            return like.isLiked();
        } else{
            Likes newlike = new Likes(user,post,true);
            likeRepo.save(newlike);
            return true;
        }

    }
}
