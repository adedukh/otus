package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.otus.spring.dao.CSVFileDaoSimple;
import ru.otus.spring.dao.QADao;
import ru.otus.spring.domain.QA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@PropertySource("classpath:application.properties")
public class TestAnswersServiceImpl implements TestAnswersService {
    @Autowired
    private QADao qaDao;

    @Autowired
    private CSVFileDaoSimple csvFileDaoSimple;

    private List<String> tests;
    private String lastName;
    private String firstName;

    @Value("${csvfile}")
    private String csvfile;

    @Value("${answersnum}")
    private int answersnum;

    public void Run() throws IOException {
        //System.out.println("TestAnswersServiceImpl Run");

        QA qa = readQuestions();

        getNames();
        tests = askQuestion();

        int answers = checkAnswers(qaDao, tests);
        int needAnswers = answersnum;

        if (needAnswers <= answers) {
            System.out.println("Dear, " + lastName + " " + firstName + "! You passed the test successfully! Correct answers " + answers + " out of " + qaDao.getQList().size());
        }
        else {
            System.out.println("Dear, " + lastName + " " + firstName + "! Sorry, you have not passed the test. Correct answers " + answers + " out of " + qaDao.getQList().size());
        }

    }

    public QA readQuestions() throws IOException {

        List<String> fileText = csvFileDaoSimple.getCSVFile(csvfile);
        QA qaList = qaDao.getQA(fileText);

        return qaList;

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
