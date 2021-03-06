package ru.otus.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.spring.service.CSVFileService;
import ru.otus.spring.service.QAService;
import ru.otus.spring.service.TestAnswersService;

import java.io.*;

@ComponentScan
public class Main {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        TestAnswersService testAnswersService = context.getBean(TestAnswersService.class);

        testAnswersService.Run();

        context.close();
    }

}
