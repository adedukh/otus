package ru.otus.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.spring.domain.QA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeString.substring;

@Component
public class QADaoSimple implements QADao {
    @Autowired
    private QA qa;

    public QADaoSimple(QA qa) {
        //System.out.println("QADaoSimple Constructor");
        this.qa = qa;
    }

    @Override
    public QA getQA(List<String> questionsText) throws IOException {
        //System.out.println("QADaoSimple setQA");
        ArrayList<String> questions = new ArrayList<>();
        ArrayList<String> answers = new ArrayList<>();

        for (String row : questionsText) {
            questions.add(substring(row, 0, row.indexOf("#")));
            answers.add(substring(row, row.indexOf("#")+1, row.indexOf(";")));
        }
        this.qa.setQuestions(questions);
        this.qa.setAnswers(answers);

        return  this.qa;
    }

    @Override
    public void printQA() {
        //System.out.println("QADaoSimple printQA");
        this.qa.printQA();
    }

    @Override
    public List<String> getQList() {
        //System.out.println("QADaoSimple getQList");
        return qa.getQuestions();
    }

    @Override
    public List<String> getAList() {
        //System.out.println("QADaoSimple getAList");
        return qa.getAnswers();
    }


}
