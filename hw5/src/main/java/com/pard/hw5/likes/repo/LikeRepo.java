package com.pard.hw5.likes.repo;

import com.pard.hw5.likes.entity.Likes;
import com.pard.hw5.post.entity.Post;
import com.pard.hw5.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepo extends JpaRepository<Likes,Long> {
    Optional<Likes> findByUserAndPost(User user, Post post);
}
