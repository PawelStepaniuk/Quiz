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

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    private QuestionDao questionDao;
    private AnswerDao answerDao;
    private Question question = new Question();
    private Answer answer = new Answer();
    private QuizDao quizDao = new Quiz();


    @GetMapping("/questions/add")
    public String addQuestion() {
        return "add";
    }

    @PostMapping("/questions")
    public String addQuestion(@RequestParam String questionContent, @RequestParam String answer1, @RequestParam String answer2,
                              @RequestParam String answer3, @RequestParam String answer4, @RequestParam(required = false) String correctAnswer1,
                              @RequestParam(required = false) String correctAnswer2, @RequestParam(required = false) String correctAnswer3, @RequestParam(required = false) String correctAnswer4) {

        Question question = new Question();
        List<Answer> answerList = new ArrayList<>();
        answerList.add(new Answer(answer1,correctAnswer1));
        answerList.add(new Answer(answer2,correctAnswer2));
        answerList.add(new Answer(answer3,correctAnswer3));
        answerList.add(new Answer(answer4,correctAnswer4));
        question.setContent(questionContent);
        question.setAnswers(answerList);
        questionDao.save(question);
        answerDao.save(new Answer(answer1,correctAnswer1));
        answerDao.save(new Answer(answer2,correctAnswer2));
        answerDao.save(new Answer(answer3,correctAnswer3));
        answerDao.save(new Answer(answer4,correctAnswer4));
        return "redirect:/questions/all";
    }

    @GetMapping("/answers/{questionID}")
    public String addAnswerById(@PathVariable Long questionID, @ModelAttribute Answer answer) {
        Question foundQuestion = question.findQuestionByID(questionID, questionDao);
        foundQuestion.addAnswer(answer);
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
       try{ System.out.println(answerDao.count());}
       catch (NullPointerException e){
           System.out.println(e.getMessage() + " answerdao");
       }
        modelMap.put("questions", questionDao.findAll());

        return "all";
    }

}
