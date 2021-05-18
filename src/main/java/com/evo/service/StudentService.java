package com.evo.service;

import java.util.List;

import com.evo.model.Student;

public interface StudentService {

    public void saveStudent(List<Student> studentList);

    public List<Student> getStudents();

}