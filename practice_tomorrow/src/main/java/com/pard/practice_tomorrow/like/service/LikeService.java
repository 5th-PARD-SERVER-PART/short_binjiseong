package com.pard.practice_tomorrow.like.service;

import com.pard.practice_tomorrow.like.entity.Likes;
import com.pard.practice_tomorrow.like.repo.LikeRepo;
import com.pard.practice_tomorrow.post.entity.Post;
import com.pard.practice_tomorrow.post.repo.PostRepo;
import com.pard.practice_tomorrow.user.entity.User;
import com.pard.practice_tomorrow.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepo likeRepo;
    private final UserRepo userRepo;
    private final PostRepo postRepo;

    public boolean toggleLike(Long userId, Long postId){

        User user = userRepo.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
        Post post = postRepo.findById(postId).orElseThrow(()->new RuntimeException("Post not found"));
        Optional<Likes> existingLike = likeRepo.findByUserAndPost(user,post);

        if(existingLike.isPresent()){
            Likes likes = existingLike.get();
            likes.toggle();
            likeRepo.save(likes);
            return false;
        } else{
            Likes newlike = new Likes(user,post,true);
            likeRepo.save(newlike);
            return true;
        }

    }
}
