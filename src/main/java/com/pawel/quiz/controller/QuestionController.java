package com.pawel.quiz.controller;

import com.pawel.quiz.dao.QuestionDao;
import com.pawel.quiz.model.Question;
import com.pawel.quiz.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    private QuestionDao questionDao;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/questions/add")
    public String addQuestion() {
        return "add";
    }

    @GetMapping("/questions")
    public String addQuestion(@ModelAttribute Question question) {
        questionDao.save(question);
        return "redirect:/questions/all";
    }

    @GetMapping("/questions/quiz")
    public String startQuiz(ModelMap map) {

        Iterator<Question> questionIterator = questionDao.findAll().iterator();
        List<Question> questionList = new ArrayList<>();
        questionIterator.forEachRemaining(questionList::add);
        Quiz quiz = new Quiz();
        map.put("questions",quiz.generateQuizQuestionList(questionList));

        return "quiz";
    }

    public static void main(String[] args) {

    }

    @GetMapping("/questions/all")
    public String showQuestions(ModelMap modelMap) {

        modelMap.put("questions", questionDao.findAll());

        return "all";
    }

}
