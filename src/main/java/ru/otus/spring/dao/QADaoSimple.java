package ru.otus.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.spring.domain.CSVFile;
import ru.otus.spring.domain.QA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
    public void setQA(CSVFile csvFile) throws IOException {
        //System.out.println("QADaoSimple setQA");
        ArrayList<String> questions = new ArrayList<>();
        ArrayList<String> answers = new ArrayList<>();

        for (String[] row : csvFile.getCsvData()) {
            questions.add(substring(Arrays.toString(row), 1, Arrays.toString(row).indexOf("#") - 1));
            answers.add(substring(Arrays.toString(row), Arrays.toString(row).indexOf("#")+1, Arrays.toString(row).indexOf(",")));
        }
        this.qa.setQuestions(questions);
        this.qa.setAnswers(answers);
    }

    @Override
    public void printQA() {
        //System.out.println("QADaoSimple printQA");
        this.qa.printQA();
    }

    @Override
    public ArrayList<String> getQList() {
        //System.out.println("QADaoSimple getQList");
        return qa.getQuestions();
    }

    @Override
    public ArrayList<String> getAList() {
        //System.out.println("QADaoSimple getAList");
        return qa.getAnswers();
    }

    @Override
    public int getQuestionNum(){
        //System.out.println();
        return qa.getNumAnswers();
    }

}
