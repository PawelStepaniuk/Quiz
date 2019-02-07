package com.pawel.quiz.model;

import com.pawel.quiz.dao.QuestionDao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Question findQuestionByID(Long id, QuestionDao questionDao) {
        Iterator<Question> questionIterator = questionDao.findAll().iterator();
        List<Question> questionList = new ArrayList<>();
        questionIterator.forEachRemaining(questionList::add);

        return questionList.get(id.intValue());
    }

    public List<Answer> getCorrectAnswer() {
            List<Answer> correctAnswers = new ArrayList<>();
        for (int i = 0; i < answers.size(); i++) {
            if(answers.get(i).getCorrect()!=null) {
                correctAnswers.add(answers.get(i));
            }
        }
        return correctAnswers;
    }
}
