package ru.otus.spring.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import ru.otus.spring.domain.RightAnswersNum;
import ru.otus.spring.domain.TNum;

@Component
@PropertySource("classpath:application.properties")
public class RightAnswersNumDaoSimple implements RightAnswersNumDao {
    private final int rNum;

    public RightAnswersNumDaoSimple(@Value("${answersnum}") int rNum) {
        //System.out.println("RightAnswersNumDaoSimple Constructor");
        this.rNum = rNum;
    }

    @Override
    public RightAnswersNum getrNum() {
        return new RightAnswersNum(rNum);
    }
}
