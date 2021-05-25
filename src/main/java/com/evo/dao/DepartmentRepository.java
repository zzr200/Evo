package com.evo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.evo.model.Department;
import com.evo.model.Student;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

    public Department findDepartmentByName(String name);
    public Department findDepartmentById(Long id);
    
    @Query("SELECT u FROM Student u WHERE u.name = ?1")
    public Student findStudent(String name);
}