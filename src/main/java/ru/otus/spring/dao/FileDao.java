package ru.otus.spring.dao;

import ru.otus.spring.domain.CSVFile;

import java.io.IOException;

public interface FileDao {
    CSVFile getCSVFile() throws IOException;
}
