package com.pard.practice_tomorrow.post.repo;

import com.pard.practice_tomorrow.post.entity.Post;
import com.pard.practice_tomorrow.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Long> {
    List<Post> findAllByUser_UserId(Long userId);

}
