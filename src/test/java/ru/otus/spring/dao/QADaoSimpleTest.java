package ru.otus.spring.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.spring.domain.QA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс dao/QADaoSimpleTest")
class QADaoSimpleTest {
    @Test
    @DisplayName("Проверка заполненности вопросов и ответов")
    void isFillListQuestionsAnswers () throws IOException {
        QADao qaMock = Mockito.mock(QADao.class);

        List<String> questionsText = new ArrayList<>();
        questionsText.add("1 + 2 = #3;");
        questionsText.add("5 - 3 = #2;");
        questionsText.add("4 / 2 = #2;");
        System.out.println(questionsText.toString());

        QA qaList = qaMock.getQA(questionsText);

        assertEquals(qaList.getQuestions().size(), 3);
        //assertThat(qaList.getQuestions().size()).hasSize(3);
        //assertThat(qaList).isEqualTo(questionsText);

    }

}