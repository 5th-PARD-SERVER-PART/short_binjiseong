package com.pard.shortkathon.progress.controller;

import com.pard.shortkathon.progress.dto.UserNameReqDto;
import com.pard.shortkathon.progress.entity.Progress;
import com.pard.shortkathon.progress.service.ProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/progress")
public class ProgressController {
    private final ProgressService progressService;

    @PostMapping("/init")
    public Progress initProgress(@RequestBody UserNameReqDto reqDto) {
        return progressService.initProgress(reqDto.getUserName());
    }

    @GetMapping("/latest")
    public Progress getLatestProgress(@RequestParam String userName) {
        return progressService.getLatestProgress(userName)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자 진행 기록이 없습니다."));
    }
}
