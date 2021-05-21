package ru.otus.spring.service;

import ru.otus.spring.domain.CSVFile;

import java.io.IOException;

public interface CSVFileService {
    CSVFile getQuestionList() throws IOException;
}
