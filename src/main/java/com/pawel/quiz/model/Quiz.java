package com.pawel.quiz.model;

import com.pawel.quiz.dao.QuestionDao;
import com.pawel.quiz.dao.QuizDao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Quiz implements QuizDao {



    public List<Question> generateQuizQuestionList(QuestionDao questionDao) {
        Iterator<Question> questionIterator = questionDao.findAll().iterator();
        List<Question> questionList = new ArrayList<>();
        questionIterator.forEachRemaining(questionList::add);
        Collections.shuffle(questionList);
        return questionList;
    }
//    public Question findQuestionByID(Long id, QuestionDao questionDao){
//        Iterator<Question> questionIterator = questionDao.findAll().iterator();
//        List<Question> questionList = new ArrayList<>();
//        questionIterator.forEachRemaining(questionList::add);
//
//        return questionList.get(id.intValue());
//
//    }
}
