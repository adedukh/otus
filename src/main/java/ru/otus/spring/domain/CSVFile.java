package ru.otus.spring.domain;

import java.util.List;

public class CSVFile {
    private final List<String[]> csvData;

    public CSVFile(List<String[]> csvData) {
        //System.out.println("CSVFile Constructor");
        this.csvData = csvData;
    }

    public List<String[]> getCsvData() {
        //System.out.println("CSVFile getCsvData");
        return csvData;
    }
}
