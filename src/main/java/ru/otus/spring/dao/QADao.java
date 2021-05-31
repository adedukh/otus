package ru.otus.spring.dao;

import ru.otus.spring.domain.CSVFile;

import java.io.IOException;
import java.util.List;

public interface QADao {
    void setQA (CSVFile csvFile) throws IOException;
    void printQA();
    List<String> getQList();
    List<String> getAList();

}
