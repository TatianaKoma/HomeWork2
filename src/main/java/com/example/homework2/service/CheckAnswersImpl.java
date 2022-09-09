package com.example.homework2.service;

import java.util.List;
import java.util.stream.IntStream;

public class CheckAnswersImpl implements CheckAnswers {

    @Override
    public int getScoreForTest(List<Integer> studentChoices, List<Integer> correctAnswers) {
        return (int) IntStream.range(0, studentChoices.size()).filter(i -> studentChoices.get(i) ==
                correctAnswers.get(i)).count();
    }
}
