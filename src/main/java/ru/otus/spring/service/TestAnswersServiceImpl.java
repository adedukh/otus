package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.spring.dao.QADao;
import ru.otus.spring.dao.RightAnswersNumDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class TestAnswersServiceImpl implements TestAnswersService {
    @Autowired
    private QADao qaDao;

    @Autowired
    private RightAnswersNumDao rightAnswersNumDao;

    @Autowired
    private QAService qaService;

    private List<String> tests;
    private String lastName;
    private String firstName;

    public void Run() throws IOException {
        //System.out.println("TestAnswersServiceImpl Run");
        qaService.prepareQuestions();
        getNames();
        tests = askQuestion();

        int answers = checkAnswers(qaDao, tests);
        int needAnswers = rightAnswersNumDao.getrNum().getrNum();

        if (needAnswers <= answers) {
            System.out.println("Dear, " + lastName + " " + firstName + "! You passed the test successfully! Correct answers " + answers + " out of " + qaDao.getQList().size());
        }
        else {
            System.out.println("Dear, " + lastName + " " + firstName + "! Sorry, you have not passed the test. Correct answers " + answers + " out of " + qaDao.getQList().size());
        }

    }

    private void getNames() throws IOException {
        //System.out.println("TestAnswersServiceImpl getNames");
        Scanner console = new Scanner(System.in);

        System.out.print ("LastName: ");
        this.lastName = console.nextLine();
        System.out.print("FirstName: ");
        this.firstName = console.nextLine();
    }

    private List<String> askQuestion() throws IOException {
        //System.out.println("TestAnswersServiceImpl askQuestion");
        List<String> testAnswers = new ArrayList<>();
        List<String> testQuestions = qaDao.getQList();

        Scanner console = new Scanner(System.in);

        for (int i = 0; i < testQuestions.size(); i++)
        {
            System.out.print(testQuestions.get(i));
            testAnswers.add(i, console.nextLine());
        }

        return testAnswers;
    }

    private int checkAnswers(QADao qaDao, List<String> testAnswers) {
        int cnt = 0;

        for (int i = 0; i < qaDao.getAList().size(); i++) {
            if (qaDao.getAList().get(i).equals(testAnswers.get(i))) cnt++;

        }

        return cnt;
    }
}
