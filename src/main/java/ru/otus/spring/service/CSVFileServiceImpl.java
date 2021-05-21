package ru.otus.spring.service;

import ru.otus.spring.dao.FileDao;
import ru.otus.spring.domain.CSVFile;

import java.io.IOException;

public class CSVFileServiceImpl implements CSVFileService{
    private FileDao fileDao;

    public CSVFileServiceImpl(FileDao fileDao) {this.fileDao = fileDao; }

    @Override
    public CSVFile getQuestionList() throws IOException
    {
        return fileDao.getCSVFile();
    }
}
