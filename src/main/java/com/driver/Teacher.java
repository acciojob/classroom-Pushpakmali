package com.driver;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Teacher {

    private String name;

    private int numberOfStudents;

    private int age;

    public Teacher() {

    }

    public Teacher(String name, int numberOfStudents, int age) {
        this.name = name;
        this.numberOfStudents = numberOfStudents;
        this.age = age;
    }
}