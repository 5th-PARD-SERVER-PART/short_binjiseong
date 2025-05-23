package com.pard.shortkathon.question.repo;

import com.pard.shortkathon.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question,Long> {
}
