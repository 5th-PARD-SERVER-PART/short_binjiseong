package com.pard.practice_tomorrow.user.repo;

import com.pard.practice_tomorrow.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {

}
