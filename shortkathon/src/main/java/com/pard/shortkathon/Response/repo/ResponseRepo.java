package com.pard.shortkathon.Response.repo;

import com.pard.shortkathon.Response.entity.Response;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResponseRepo extends JpaRepository<Response,Long> {
    List<Response> findByUserId(Long userId);
}
