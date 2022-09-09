package com.example.homework2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    private String name;
    private String surname;
    private int examScore;

    @Override
    public String toString() {
        return "Student: " + name + " " + surname + ", your examScore is " + examScore +".";
    }
}