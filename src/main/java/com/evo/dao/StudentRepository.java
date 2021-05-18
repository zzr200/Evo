package com.evo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
