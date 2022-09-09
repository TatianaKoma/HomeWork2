package com.example.homework2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class CsvParserImpl implements CsvParser {
    public static final String DELIMITER = ",";

    @Value("${file.en}")
    private String path;

    @Override
    public Map<String, List<String>> getDataFromCsvFile() throws IOException {
        Map<String, List<String>> questionsWithAnswers = new LinkedHashMap<>();
        Resource resource = loadDataWithClassPathResource(path);
        InputStream inputStream = resource.getInputStream();
        try (InputStreamReader streamReader =
                     new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            String line = " ";
            while ((line = reader.readLine()) != null) {
                String[] tempArr = line.split(DELIMITER);
                String question = tempArr[0];
                List<String> answersList = new ArrayList<>(Arrays.asList(tempArr).subList(1, tempArr.length));
                questionsWithAnswers.put(question, answersList);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return questionsWithAnswers;
    }

    private Resource loadDataWithClassPathResource(String path) {
        return new ClassPathResource(path);
    }
}
