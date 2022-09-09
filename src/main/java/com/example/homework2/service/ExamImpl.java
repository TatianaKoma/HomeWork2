package com.example.homework2.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.example.homework2.service.ResourceBundleService.getLocalString;

public class ExamImpl implements Exam {
    private static final List<Integer> CORRECT_ANSWERS = Arrays.asList(2, 2, 2, 3, 1);
    private final CsvParserImpl csvParser;
    private final AskQuestionsImpl askQuestions;
    private final CheckAnswersImpl checkAnswers;

    public ExamImpl(CsvParserImpl csvParser, AskQuestionsImpl askQuestions, CheckAnswersImpl checkAnswers) {
        this.csvParser = csvParser;
        this.askQuestions = askQuestions;
        this.checkAnswers = checkAnswers;
    }

    @Override
    public void examStudents() throws IOException {
        System.out.println(getLocalString("hello"));
        Map<String, List<String>> questionsWithAnswers = csvParser.getDataFromCsvFile();
        String name = askQuestions.askInfoQuestions(getLocalString("name"));
        String surname = askQuestions.askInfoQuestions(getLocalString("surname"));
        System.out.println(getLocalString("start"));
        List<Integer> studentChoices = askQuestions.askExamQuestions(questionsWithAnswers);
        int examScore = checkAnswers.getScoreForTest(studentChoices, CORRECT_ANSWERS);
        System.out.printf(getLocalString("result"), name, surname, examScore);
        System.out.println();
    }
}
