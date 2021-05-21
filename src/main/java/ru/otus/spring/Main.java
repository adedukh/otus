package ru.otus.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.service.CSVFileService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeString.substring;

public class Main {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        CSVFileService csvFileService = context.getBean(CSVFileService.class);

        List<String[]> csvFile = csvFileService.getQuestionList().getCsvData();

        for (String[] row : csvFile) {
            //System.out.println(Arrays.toString(row));
            System.out.println(substring(Arrays.toString(row), 1, Arrays.toString(row).length() - 1));
        }
        context.close();
    }

}
