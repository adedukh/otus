package ru.otus.spring.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@PropertySource("classpath:application.properties")
public class QA {
    private ArrayList<String> questions;
    private ArrayList<String> answers;
    private int numAnswers;

    public QA(ArrayList<String> questions, ArrayList<String> answers, @Value("${answersnum}") int numAnswers) {
        //System.out.println("QA Constructor");
        this.numAnswers = numAnswers;
        this.questions = questions;
        this.answers = answers;
    }

    public ArrayList<String> getQuestions() {
        return questions;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public int getNumAnswers() { return numAnswers;    }

    public void setQuestions(ArrayList<String> questions) {
        //System.out.println("QA setQuestions");
        this.questions = questions;
    }

    public void setAnswers(ArrayList<String> answers) {
        //System.out.println("QA setAnswers");
        this.answers = answers;
    }

    public void printQA() {
        //System.out.println("QA printQA");
        for (int i = 0; i< questions.size(); i++) {
            System.out.println(questions.get(i));
            System.out.println(answers.get(i));
        }
    }

}
