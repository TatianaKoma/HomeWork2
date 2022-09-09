package com.example.homework2.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

import static com.example.homework2.service.ResourceBundleService.getLocalString;

public class AskQuestionsImpl implements AskQuestions {
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public List<Integer> askExamQuestions(Map<String, List<String>> questionsWithAnswers) {
        List<Integer> userChoices = new ArrayList<>();

        Iterator<Map.Entry<String, List<String>>> iterator = questionsWithAnswers.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> pair = iterator.next();
            System.out.println(pair.getKey());
            System.out.println(getLocalString("options"));
            List<String> answersVariants = pair.getValue();
            IntStream.range(0, answersVariants.size()).mapToObj(i -> (i + 1) +
                    answersVariants.get(i)).forEachOrdered(System.out::println);
            System.out.println(getLocalString("choice"));
            String answer = SCANNER.nextLine();
            int studentAnswer = checkStudentChoice(answer);
            userChoices.add(studentAnswer);

            iterator.remove();
        }
        return userChoices;
    }

    @Override
    public String askInfoQuestions(String question) {
        System.out.println(question);
        return SCANNER.nextLine();
    }

    private int checkStudentChoice(String answer) {
        int studentAnswer;
        while (true) {
            try {
                studentAnswer = Integer.parseInt(answer);
                return studentAnswer;
            } catch (NumberFormatException e) {
                System.out.println(getLocalString("incorrect"));
                answer = SCANNER.nextLine();
            }
        }
    }
}
