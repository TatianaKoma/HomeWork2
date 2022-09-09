package com.example.homework2.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public interface AskQuestions {
    List<Integer> askExamQuestions(Map<String, List<String>> questionsWithAnswers) throws UnsupportedEncodingException;

    String askInfoQuestions(String question);
}
