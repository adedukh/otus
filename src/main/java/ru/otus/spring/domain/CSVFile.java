package ru.otus.spring.domain;

import java.util.List;

public class CSVFile {
    private final List<String[]> csvData;

    public CSVFile(List<String[]> csvData) {
        this.csvData = csvData;
    }

    public List<String[]> getCsvData() {
        return csvData;
    }
}
