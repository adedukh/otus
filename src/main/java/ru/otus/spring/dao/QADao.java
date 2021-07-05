package ru.otus.spring.dao;

import ru.otus.spring.domain.QA;

import java.io.IOException;
import java.util.List;

public interface QADao {
    QA getQA(List<String> questionsText) throws IOException;
    void printQA();
    List<String> getQList();
    List<String> getAList();


}
