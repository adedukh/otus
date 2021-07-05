package ru.otus.spring.domain;

import org.springframework.stereotype.Component;

public class RightAnswersNum implements TNum {
    private int rNum;

    public RightAnswersNum(int rNum) {
        //System.out.println("RightAnswersNum Constructor");
        this.rNum = rNum;
    }

    @Override
    public int getrNum() {
        return rNum;
    }
}
