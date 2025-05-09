package com.pard.hw5.post.repo;

import com.pard.hw5.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByUser_UserId(Long userId);
}
