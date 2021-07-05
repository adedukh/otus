package ru.otus.spring.dao;

import java.io.IOException;
import java.util.List;

public interface FileDao {
    List<String> getCSVFile(String fileName) throws IOException;
}
