package com.pard.shortkathon.question.controller;

import com.pard.shortkathon.question.dto.QuestionReqDto;
import com.pard.shortkathon.question.dto.QuestionResDto;
import com.pard.shortkathon.progress.dto.UserNameReqDto;
import com.pard.shortkathon.question.service.QuestionService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("")
    public List<QuestionResDto> readAll(){
        return questionService.readAll();
    }

    @PostMapping("")
    public String createQuestion(@RequestBody QuestionReqDto questionReqDto) {
        questionService.save(questionReqDto);
        return "Question 저장 성공";
    }
    @PatchMapping("/{Id}")
    public String updateById(@PathVariable Long Id, @RequestBody QuestionReqDto questionReqDto){
        questionService.updateById(Id, questionReqDto);
        return "입력한 "+Id+"번 내용 수정완료!";
    }
    @DeleteMapping("/{Id}")
    public String deleteById(@PathVariable Long Id){
        questionService.deleteById(Id);
        return "입력한 "+Id+"번 삭제완료!";
    }
    @PostMapping("/start")
    public String startSurvey(@RequestBody UserNameReqDto userNameReqDto) {
        String userName = userNameReqDto.getUserName();
        questionService.initUser(userName);
        return userName + "님 설문을 시작합니다!";
    }
    @GetMapping("/next")
    public QuestionResDto getNextQuestion(@RequestParam String userName) {
        return questionService.getNextQuestionForUser(userName);
    }
}
