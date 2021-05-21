package ru.otus.spring.dao;

import au.com.bytecode.opencsv.CSVReader;
import ru.otus.spring.domain.CSVFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class CSVFileDaoSimple implements FileDao{
    private String  fileName;

    public CSVFileDaoSimple(String fileName) {
        this.fileName = fileName;
    }


    public CSVFile getCSVFile() throws IOException {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        CSVReader reader = new CSVReader(new InputStreamReader(inputStream), ';');

        return new CSVFile(reader.readAll());
    }
}
