package com.evo.controller;

import com.evo.dao.DepartmentRepository;
import com.evo.dao.StudentRepository;
import com.evo.model.Department;
import com.evo.model.Student;
import com.evo.service.DepartmentService;
import com.evo.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/studentList", method = RequestMethod.GET)
    public @ResponseBody List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/saveStudent/{deptName}")
    public String saveStudent(@RequestBody List<Student> studentList, @PathVariable String deptName){
        try {
            Department dept = departmentService.findDepartment(deptName.toUpperCase());

            for(Student student: studentList)
                student.setDepartment(dept);

            studentService.saveStudent(studentList);
            return "Student saved successfully..";
        }catch (Exception ex){
            ex.printStackTrace();
            return "Error in saving Student ..";
        }
    }
}
