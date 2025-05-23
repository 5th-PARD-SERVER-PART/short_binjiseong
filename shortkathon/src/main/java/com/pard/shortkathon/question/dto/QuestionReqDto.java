package com.pard.shortkathon.question.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionReqDto {
    private String questionText;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String option5;

}

