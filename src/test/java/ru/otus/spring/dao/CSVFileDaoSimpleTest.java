package ru.otus.spring.dao;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;


import java.io.IOException;
import java.util.List;


@DisplayName("Класс dao/CSVFileDaoSimple")
class CSVFileDaoSimpleTest {

    @Test
    @DisplayName("Не пустой csv файл")

    void shouldHaveNotNullCSVFile() throws IOException {
        CSVFileDaoSimple fileDao = Mockito.mock(CSVFileDaoSimple.class);

        List<String> questions =  fileDao.getCSVFile("question_list.csv");
        System.out.println(questions.size());

        assertThat(questions).hasSize(5);

    }

}