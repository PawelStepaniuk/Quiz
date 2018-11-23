package com.pawel.quiz.dao;

import com.pawel.quiz.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface AnswerDao extends CrudRepository<Question,Long> {
}
