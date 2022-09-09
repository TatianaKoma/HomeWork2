package com.example.homework2;

import com.example.homework2.service.AskQuestionsImpl;
import com.example.homework2.service.CheckAnswersImpl;
import com.example.homework2.service.CsvParserImpl;
import com.example.homework2.service.ExamImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class MyConfig {

    @Bean
    public CsvParserImpl csvParserImpBean() {
        return new CsvParserImpl();
    }

    @Bean
    public AskQuestionsImpl askQuestionsImpBean() {
        return new AskQuestionsImpl();
    }

    @Bean
    public CheckAnswersImpl checkAnswersImpBean() {
        return new CheckAnswersImpl();
    }

    @Bean
    public ExamImpl examImpBean() {
        return new ExamImpl(csvParserImpBean(), askQuestionsImpBean(), checkAnswersImpBean());
    }
}
