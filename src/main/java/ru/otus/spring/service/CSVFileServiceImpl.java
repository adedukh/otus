package ru.otus.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.spring.dao.FileDao;
import ru.otus.spring.domain.CSVFile;

import java.io.IOException;

@Component
public class CSVFileServiceImpl implements CSVFileService{
    @Autowired
    private FileDao fileDao;

    public CSVFileServiceImpl(FileDao fileDao) {
        //System.out.println("CSVFileServiceImpl Constructor");
        this.fileDao = fileDao;
    }

    @Override
    public CSVFile getQuestionList() throws IOException
    {
        //System.out.println("CSVFileServiceImpl getQuestionList");
        return fileDao.getCSVFile();
    }
}
