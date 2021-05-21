package ru.otus.spring.dao;

import au.com.bytecode.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.otus.spring.domain.CSVFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
@PropertySource("classpath:application.properties")
public class CSVFileDaoSimple implements FileDao{
    private final String  fileName;

    public CSVFileDaoSimple(@Value("${csvfile}") String fileName) {
        //System.out.println("CSVFileDaoSimple Constructor");
        this.fileName = fileName;
    }

    @Override
    public CSVFile getCSVFile() throws IOException {
        //System.out.println("CSVFileDaoSimple getCSVFile");
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        CSVReader reader = new CSVReader(new InputStreamReader(inputStream), ';');

        return new CSVFile(reader.readAll());
    }
}
