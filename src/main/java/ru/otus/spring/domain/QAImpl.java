package ru.otus.spring.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PropertySource("classpath:application.properties")
public class QAImpl implements QA{
    private List<String> questions;
    private List<String> answers;

    public QAImpl(List<String> questions, List<String> answers) {
        //System.out.println("QA Constructor");
        this.questions = questions;
        this.answers = answers;
    }

    @Override
    public List<String> getQuestions() {
        return questions;
    }

    @Override
    public List<String> getAnswers() {
        return answers;
    }

    @Override
    public void setQuestions(List<String> questions) {
        //System.out.println("QA setQuestions");
        this.questions = questions;
    }

    @Override
    public void setAnswers(List<String> answers) {
        //System.out.println("QA setAnswers");
        this.answers = answers;
    }

    @Override
    public void printQA() {
        //System.out.println("QA printQA");
        for (int i = 0; i< questions.size(); i++) {
            System.out.println(questions.get(i));
            System.out.println(answers.get(i));
        }
    }

}
