package com.pard.shortkathon.question.service;



import com.pard.shortkathon.progress.entity.Progress;
import com.pard.shortkathon.progress.repo.ProgressRepo;
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
    private final ProgressRepo progressRepo;

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
    public void initUser(String userName) {
        progressRepo.findByUserName(userName).ifPresentOrElse(
                progress -> {
                    // 이미 존재할 경우, currentIndex 초기화
                    progress = Progress.builder()
                            .id(progress.getId())
                            .userName(userName)
                            .currentIndex(0)
                            .build();
                    progressRepo.save(progress);
                },
                () -> {
                    // 존재하지 않으면 새로 저장
                    progressRepo.save(Progress.builder()
                            .userName(userName)
                            .currentIndex(0)
                            .build());
                }
        );
    }

    public QuestionResDto getNextQuestionForUser(String userName) {
        List<Question> questions = questionRepo.findAll();

        Progress progress = progressRepo.findByUserName(userName)
                .orElseGet(() -> progressRepo.save(Progress.builder()
                        .userName(userName)
                        .currentIndex(0)
                        .build()));

        int index = progress.getCurrentIndex();

        if (index >= questions.size()) {
            throw new RuntimeException("모든 질문을 완료했습니다.");
        }

        Question question = questions.get(index);
        progress = Progress.builder()
                .id(progress.getId())
                .userName(userName)
                .currentIndex(index + 1)
                .build();
        progressRepo.save(progress);

        return QuestionResDto.builder()
                .id(question.getId())
                .userName(userName)
                .questionText(userName + "님 " + question.getQuestionText())
                .option1(question.getOption1())
                .option2(question.getOption2())
                .option3(question.getOption3())
                .option4(question.getOption4())
                .option5(question.getOption5())
                .build();
    }
}
