package com.pawel.quiz.dao;

import com.pawel.quiz.model.Answer;
import com.pawel.quiz.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionDao extends CrudRepository<Question,Long> {
}
