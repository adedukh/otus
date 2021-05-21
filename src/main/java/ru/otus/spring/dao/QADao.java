package ru.otus.spring.dao;

import ru.otus.spring.domain.CSVFile;

import java.io.IOException;
import java.util.ArrayList;

public interface QADao {
    void setQA (CSVFile csvFile) throws IOException;
    void printQA();
    ArrayList<String> getQList();
    ArrayList<String> getAList();
    int getQuestionNum();
}
