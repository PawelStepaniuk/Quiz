package com.pawel.quiz.dao;

import com.pawel.quiz.model.Question;

import java.util.List;

public interface QuizDao {
    List<Question> generateQuizQuestionList(QuestionDao questionDao);
}
