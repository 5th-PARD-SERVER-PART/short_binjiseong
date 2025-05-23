package com.pard.shortkathon.progress.service;

import com.pard.shortkathon.progress.entity.Progress;
import com.pard.shortkathon.progress.repo.ProgressRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProgressService {
    private final ProgressRepo progressRepo;

    public Progress initProgress(String userName) {
        return progressRepo.save(Progress.builder()
                .userName(userName)
                .currentIndex(0)
                .build());
    }

    public Optional<Progress> getLatestProgress(String userName) {
        return progressRepo.findTopByUserNameOrderByIdDesc(userName);
    }

    public Progress updateProgress(Progress progress, int newIndex) {
        Progress updated = Progress.builder()
                .id(progress.getId())
                .userName(progress.getUserName())
                .currentIndex(newIndex)
                .build();
        return progressRepo.save(updated);
    }
}