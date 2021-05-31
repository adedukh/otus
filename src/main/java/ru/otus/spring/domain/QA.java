package ru.otus.spring.domain;

import java.util.List;

public interface QA {
    void setQuestions(List<String> questions);
    void setAnswers(List<String> answers);
    void printQA();
    List<String> getQuestions();
    List<String> getAnswers();
}
