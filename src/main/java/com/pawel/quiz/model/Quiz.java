package com.pawel.quiz.model;

import java.util.ArrayList;
import java.util.List;

public class Quiz {



    public List<Question> generateQuizQuestionList(List<Question> questionsBase) {
        List<Question> questionsList = new ArrayList<>();
        for (int i = 0; i < questionsBase.size(); i++) {
            questionsList.add(questionsBase.get(i));
        }

        return questionsList;
    }
}
