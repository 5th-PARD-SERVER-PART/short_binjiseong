package com.pard.practice_tomorrow.like.repo;


import com.pard.practice_tomorrow.like.entity.Likes;
import com.pard.practice_tomorrow.post.entity.Post;
import com.pard.practice_tomorrow.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepo extends JpaRepository<Likes,Long> {
    Optional<Likes> findByUserAndPost(User user, Post post);
}
