package com.pard.shortkathon.question.service;



import com.pard.shortkathon.question.dto.QuestionReqDto;
import com.pard.shortkathon.question.dto.QuestionResDto;
import com.pard.shortkathon.question.entity.Question;

import com.pard.shortkathon.question.repo.QuestionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepo questionRepo;

    public List<QuestionResDto> readAll() {
        List<Question> questions = questionRepo.findAll();
        List<QuestionResDto> questionResDtos = questions.stream().map(question ->
                        QuestionResDto.builder()
                        .id(question.getId())
                        .questionText(question.getQuestionText())
                        .option1(question.getOption1())
                        .option2(question.getOption2())
                        .option3(question.getOption3())
                        .option4(question.getOption4())
                        .option5(question.getOption5())
                        .build()).toList();
        return questionResDtos;
    }

    public void save(QuestionReqDto questionReqDto) {
        Question question = Question.builder()
                .questionText(questionReqDto.getQuestionText())
                .option1(questionReqDto.getOption1())
                .option2(questionReqDto.getOption2())
                .option3(questionReqDto.getOption3())
                .option4(questionReqDto.getOption4())
                .option5(questionReqDto.getOption5())
                .build();
        questionRepo.save(question);
    }
    @Transactional
    public void updateById(Long id,QuestionReqDto questionReqDto){
        Question question = questionRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 순서의 사용자를 찾을 수 없습니다. ID: " + id));

        question.update(questionReqDto);
        questionRepo.save(question); // 이게 없으면 DB에 저장 안됨!!!
    }
    @Transactional
    public void deleteById(Long id) {
        Question question = questionRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 순서의 사용자를 찾을 수 없습니다. ID: " + id));

        questionRepo.delete(question);
    }
}
