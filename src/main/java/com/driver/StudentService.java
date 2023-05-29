package com.driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StudentService {
    private StudentRepository studentRepository = new StudentRepository();

    public void addNewStudent(Student student) {
        studentRepository.add(student);
    }

    public void addNewTeacher(Teacher teacher) {
        studentRepository.add(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) throws StudentNameInvalidException, TeacherNameInvalidException{
        Optional<Student> opStudent = studentRepository.getStudent(student);
        Optional<Teacher> opTeacher = studentRepository.getTeacher(teacher);

        if(opStudent.isEmpty()){
            throw new StudentNameInvalidException(student);
        }
        if(opTeacher.isEmpty()){
            throw new TeacherNameInvalidException(teacher);
        }

        Teacher teacherObj = opTeacher.get();
        teacherObj.setNumberOfStudents(teacherObj.getNumberOfStudents()+1);
        studentRepository.add(teacherObj);
        studentRepository.add(student, teacher);
    }

    public Student getStudentByName(String name) throws StudentNameInvalidException{
        Optional<Student> optionalStudent = studentRepository.getStudent(name);

        if(optionalStudent.isPresent()){
            return optionalStudent.get();
        }

        throw new StudentNameInvalidException(name);
    }

    public Teacher getTeacherByName(String name) throws TeacherNameInvalidException{
        Optional<Teacher> optionalTeacher = studentRepository.getTeacher(name);
        if(optionalTeacher.isPresent()){
            return optionalTeacher.get();
        }

        throw new TeacherNameInvalidException(name);
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        return studentRepository.getStudentsByTeacherName(teacher);
    }

    public List<String> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public void deleteTeacherByName(String teacher) {
        List<String> students = getStudentsByTeacherName(teacher);
        studentRepository.deleteTeacher(teacher);

        for(String student : students){
            studentRepository.deleteStudent(student);
        }
    }

    public void deleteAllTeacher() {
        List<String> teachers = studentRepository.getAllTeacher();
        for(String teacher : teachers){
            deleteTeacherByName(teacher);
        }
    }
}
