package com.pard.shortkathon.Response.service;

import com.pard.shortkathon.Response.dto.ResponseReqDto;
import com.pard.shortkathon.Response.dto.ResponseResDto;
import com.pard.shortkathon.Response.entity.Response;
import com.pard.shortkathon.Response.repo.ResponseRepo;
import com.pard.shortkathon.question.dto.QuestionReqDto;
import com.pard.shortkathon.question.entity.Question;
import com.pard.shortkathon.question.repo.QuestionRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@RequiredArgsConstructor
public class ResponseService {
    private final QuestionRepo questionRepo;
    private final ResponseRepo responseRepo;

    @Transactional
    public void save(ResponseReqDto responseReqDto) {
        for (ResponseReqDto.Answer answer : responseReqDto.getAnswers()) {
            Question question = questionRepo.findById(answer.getQuestionId())
                    .orElseThrow(() -> new IllegalArgumentException("해당 질문이 존재하지 않습니다. ID: " + answer.getQuestionId()));

            Response response = Response.builder()
                    .userId(responseReqDto.getUserId())
                    .question(question)
                    .userAnswer(answer.getUserAnswer())
                    .build();

            responseRepo.save(response);
        }
    }
    @Transactional
    public ResponseResDto result(Long userId) {

        List<Response> responses = responseRepo.findByUserId(userId);
        if (responses.isEmpty()) {
            throw new IllegalArgumentException("해당 사용자의 응답이 없습니다: userId=" + userId);
        }

        // 점수 합산 로직: userAnswer 값이 "1"이면 +1, "2"이면 +2
        int score = 0;
        for (Response response : responses) {
            if ("1".equals(response.getUserAnswer())) {
                score += 1;
            } else if ("2".equals(response.getUserAnswer())) {
                score += 2;
            } else if ("3".equals(response.getUserAnswer())) {
                score += 3;
            } else if ("4".equals(response.getUserAnswer())) {
                score += 4;
            } else {
                score += 5;
            }
        }

        // 점수에 따라 해석된 결과 메시지 지정
        String result;
        if (score >=20 && score < 40) {
            result = "음.... 20-40점 사이라";
        } else if (score >=40 && score < 60) {
            result = "40-60점 사이 옴..";
        } else if(score >=60 && score < 80){
            result = "60-80 사이라 가능성이 높은데";
        } else if(score >=80){
            result = "80-100이라 그냥 고백해~";
        } else {
            result = "오류입니다~";
        }


        // 첫 번째 질문 정보 기준으로 ResponseResDto 구성
        Response first = responses.get(0);
        return ResponseResDto.builder()
                .userId(first.getUserId())
                .result(result)
                .build();
    }
}
