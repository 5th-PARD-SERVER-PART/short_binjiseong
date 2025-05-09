package com.pard.hw5.user.repo;


import com.pard.hw5.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
