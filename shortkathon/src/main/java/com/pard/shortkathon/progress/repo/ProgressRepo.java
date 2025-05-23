package com.pard.shortkathon.progress.repo;

import com.pard.shortkathon.progress.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgressRepo extends JpaRepository<Progress, Long> {
    Optional<Progress> findByUserName(String userName);

}
