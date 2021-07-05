package ru.otus.spring.dao;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


@Component
public class CSVFileDaoSimple implements FileDao{

    @Override
    public List<String> getCSVFile(String fileName) throws IOException  {
        List<String> questionsText = new ArrayList<>();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        Scanner sсanner = new Scanner(inputStream).useDelimiter(Pattern.compile("\\r\\n|\\r|\\n"));


                while (sсanner.hasNext()) {
                    String question = sсanner.hasNext() ? sсanner.next() : "";
                    questionsText.add(question);
                }


        return questionsText;
    }
}
