package com.example.homework2;

import com.example.homework2.service.ExamImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

@SpringBootApplication
@PropertySource(value = "classpath:application.properties")
public class Application {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        ExamImpl exam = context.getBean("examImpBean", ExamImpl.class);
        exam.examStudents();
        context.close();
    }
}
