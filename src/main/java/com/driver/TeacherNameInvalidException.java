package com.driver;

public class TeacherNameInvalidException extends RuntimeException{
    public TeacherNameInvalidException(String teacher) {
        super("Teacher Not found with name : "+teacher);
    }
}
