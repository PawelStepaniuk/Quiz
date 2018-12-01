package com.pawel.quiz.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String content;
    private String answer_true;
    private String answer_false1;
    private String answer_false2;
    private String answer_false3;
//
//    @OneToMany(mappedBy = "question")
//    private List<Answer> answers = new ArrayList<>();

    public String getAnswer_true() {
        return answer_true;
    }

    public void setAnswer_true(String answer_true) {
        this.answer_true = answer_true;
    }

    public String getAnswer_false1() {
        return answer_false1;
    }

    public void setAnswer_false1(String answer_false1) {
        this.answer_false1 = answer_false1;
    }

    public String getAnswer_false2() {
        return answer_false2;
    }

    public void setAnswer_false2(String answer_false2) {
        this.answer_false2 = answer_false2;
    }

    public String getAnswer_false3() {
        return answer_false3;
    }

    public void setAnswer_false3(String answer_false3) {
        this.answer_false3 = answer_false3;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
