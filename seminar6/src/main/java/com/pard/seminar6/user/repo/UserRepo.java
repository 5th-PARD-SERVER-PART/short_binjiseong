package com.pard.seminar6.user.repo;

import com.pard.seminar6.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {
    List<User> findByPart(String part);

}
