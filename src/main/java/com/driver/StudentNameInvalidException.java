package com.driver;

public class StudentNameInvalidException extends RuntimeException{
    public StudentNameInvalidException(String student) {
        super("Student Not found with name : "+student);
    }
}
