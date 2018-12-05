package com.pawel.quiz.controller;

import com.pawel.quiz.dao.AnswerDao;
import com.pawel.quiz.dao.QuestionDao;
import com.pawel.quiz.dao.QuizDao;
import com.pawel.quiz.model.Answer;
import com.pawel.quiz.model.Question;
import com.pawel.quiz.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    private QuestionDao questionDao;
    private Question question = new Question();
    private Answer answer = new Answer();
    private QuizDao quizDao = new Quiz();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/questions/add")
    public String addQuestion() {
        return "add";
    }

    @GetMapping("/questions")
    public String addQuestion(@ModelAttribute Question question,@ModelAttribute Answer answer) {
        System.out.println(answer.getAnswer() + " TO JEST ODPOWIEDZ");
        question.addAnswer(answer);
        questionDao.save(question);
        System.out.println(question.getAnswers().get(0).getAnswer());
        System.out.println(question.getContent());
        return "redirect:/questions/all";
    }
    @GetMapping("/answers/add")
    public String addAnswer(){
        return "addAnswer";
    }
    @GetMapping("/answers/{questionID}")
    public String addAnswerById(@PathVariable Long questionID,@ModelAttribute Answer answer) {
        Question foundQuestion = question.findQuestionByID(questionID, questionDao);
        foundQuestion.addAnswer(answer);
        foundQuestion.getAnswers().get(0);
        return "redirect:/questions/all";
    }

    @GetMapping("/questions/quiz")
    public String startQuiz(ModelMap map) {
        List<Question> questionList = quizDao.generateQuizQuestionList(questionDao);
        map.put("questions", questionList);
        return "quiz";
    }


    @GetMapping("/questions/all")
    public String showQuestions(ModelMap modelMap) {

        modelMap.put("questions", questionDao.findAll());

        return "all";
    }

}
