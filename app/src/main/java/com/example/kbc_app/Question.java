package com.example.kbc_app;

import java.util.ArrayList;
import java.util.List;

public class Question {

    int id;
    String questions;

    List<Options> options;

    int answer_option;
    int answer_given_option;


    public Question(int id, String questions, List<Options> options, int answer_option) {
        this.id = id;
        this.questions = questions;
        this.options = options;
        this.answer_option = answer_option;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public List<Options> getOptions() {
        return options;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }

    public int getAnswer_option() {
        return answer_option;
    }

    public void setAnswer_option(int answer_option) {
        this.answer_option = answer_option;
    }

    public int getAnswer_given_option() {
        return answer_given_option;
    }

    public void setAnswer_given_option(int answer_given_option) {
        this.answer_given_option = answer_given_option;
    }
}
