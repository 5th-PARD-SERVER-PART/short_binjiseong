package com.pard.shortkathon.Response.controller;

import com.pard.shortkathon.Response.dto.ResponseReqDto;
import com.pard.shortkathon.Response.dto.ResponseResDto;
import com.pard.shortkathon.Response.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/response")
public class ResponseController {

    private final ResponseService responseService;

    @PostMapping("")
    public String submitAllResponses(@RequestBody ResponseReqDto responseReqDto) {
        responseService.save(responseReqDto);
        return "설문 응답 저장 완료";
    }

    @GetMapping("/{userId}")
    public ResponseResDto result(@PathVariable Long userId){
        return responseService.result(userId);
    }
}
