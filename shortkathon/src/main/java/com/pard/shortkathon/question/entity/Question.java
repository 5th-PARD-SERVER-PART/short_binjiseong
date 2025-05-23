package com.pard.shortkathon.question.entity;

import com.pard.shortkathon.Response.entity.Response;
import com.pard.shortkathon.question.dto.QuestionReqDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionText;

    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String option5;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Response> responses;

    public void update(QuestionReqDto questionReqDto) {
        if (questionReqDto.getQuestionText() != null && !questionReqDto.getQuestionText().trim().isEmpty()) {
            this.questionText = questionReqDto.getQuestionText();
        }
        if (questionReqDto.getOption1() != null && !questionReqDto.getOption1().trim().isEmpty()) {
            this.option1 = questionReqDto.getOption1();
        }
        if (questionReqDto.getOption2() != null && !questionReqDto.getOption2().trim().isEmpty()) {
            this.option2 = questionReqDto.getOption2();
        }
        if (questionReqDto.getOption3() != null && !questionReqDto.getOption3().trim().isEmpty()) {
            this.option3 = questionReqDto.getOption3();
        }
        if (questionReqDto.getOption4() != null && !questionReqDto.getOption4().trim().isEmpty()) {
            this.option4 = questionReqDto.getOption4();
        }
        if (questionReqDto.getOption5() != null && !questionReqDto.getOption5().trim().isEmpty()) {
            this.option5 = questionReqDto.getOption5();
        }
    }
}
