package com.pard.hw4.post.repo;

import com.pard.hw4.post.entity.Post;
import com.pard.hw4.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByUser_UserId(Long userId);
}
