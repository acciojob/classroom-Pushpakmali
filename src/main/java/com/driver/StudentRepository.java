package com.driver;

import java.util.*;

public class StudentRepository {
    private Map<String,Student> studentMap = new HashMap<>();
    private Map<String,Teacher> teacherMap = new HashMap<>();

    private Map<String, ArrayList<String>> teacherStudentPair = new HashMap<>();

    public void add(Student student) {
        studentMap.put(student.getName(), student);
    }

    public void add(Teacher teacher){
        teacherMap.put(teacher.getName(), teacher);
    }

    public void add(String student, String teacher) {
        ArrayList<String> students = teacherStudentPair.getOrDefault(teacher, new ArrayList<>());
        students.add(student);
        teacherStudentPair.put(teacher, students);
    }

    public Optional<Student> getStudent(String student) {
        if(studentMap.containsKey(student)){
            return Optional.of(studentMap.get(student));
        }

        return Optional.empty();
    }

    public Optional<Teacher> getTeacher(String teacher) {
        if(teacherMap.containsKey(teacher)){
            return Optional.of(teacherMap.get(teacher));
        }
        return Optional.empty();
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        return teacherStudentPair.getOrDefault(teacher, new ArrayList<>());
    }

    public List<String> getAllStudents() {
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteStudent(String student) {
        studentMap.remove(student);
    }

    public void deleteTeacher(String teacher) {
        teacherMap.remove(teacher);
        teacherStudentPair.remove(teacher);
    }

    public List<String> getAllTeacher() {
        return new ArrayList<>(teacherMap.keySet());
    }
}
