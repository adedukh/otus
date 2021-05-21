package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.spring.dao.QADao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

@Component
public class TestAnswersServiceImpl implements TestAnswersService {
    @Autowired
    private QADao qaDao;

    private ArrayList<String> tests;
    private String lastName;
    private String firstName;

    public void Run() throws IOException {
        //System.out.println("TestAnswersServiceImpl Run");
        getNames();
        tests = askQuestion();

        int answers = checkAnswers(qaDao, tests);
        int needAnswers = qaDao.getQuestionNum();

        if (needAnswers <= answers) {
            System.out.println("Dear, " + lastName + " " + firstName + "! You passed the test successfully! Correct answers " + answers + " out of " + qaDao.getQList().size());
        }
        else {
            System.out.println("Dear, " + lastName + " " + firstName + "! Sorry, you have not passed the test. Correct answers " + answers + " out of " + qaDao.getQList().size());
        }

    }

    private void getNames() throws IOException {
        //System.out.println("TestAnswersServiceImpl getNames");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print ("LastName: ");
        this.lastName = reader.readLine();
        System.out.print("FirstName: ");
        this.firstName = reader.readLine();
    }

    private ArrayList<String> askQuestion() throws IOException {
        //System.out.println("TestAnswersServiceImpl askQuestion");
        ArrayList<String> testAnswers = new ArrayList<>();
        ArrayList<String> testQuestions = qaDao.getQList();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < testQuestions.size(); i++)
        {
            System.out.print(testQuestions.get(i));
            testAnswers.add(i, reader.readLine());
        }

        return testAnswers;
    }

    private int checkAnswers(QADao qaDao, ArrayList<String> testAnswers) {
        int cnt = 0;

        for (int i = 0; i < qaDao.getAList().size(); i++) {
            if (qaDao.getAList().get(i).equals(testAnswers.get(i))) cnt++;

        }

        return cnt;
    }
}
