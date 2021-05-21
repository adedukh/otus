package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.spring.dao.QADao;


import java.io.IOException;

@Component
public class QAServiceImpl implements QAService{
    @Autowired
    private CSVFileService csvFileService;
    @Autowired
    private QADao qaDao;

    public QAServiceImpl(QADao qaDao) {
        //System.out.println("QAServiceImpl Constructor");
        this.qaDao = qaDao;
    }

    @Override
    public void prepareQuestions() throws IOException {
        //System.out.println("QAServiceImpl Run");
        qaDao.setQA(csvFileService.getQuestionList());
        //qaDao.printQA();
    }
}
