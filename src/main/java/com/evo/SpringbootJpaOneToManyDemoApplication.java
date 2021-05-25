package com.evo;

import com.evo.dao.DepartmentRepository;
import com.evo.dao.StudentRepository;
import com.evo.model.Department;
import com.evo.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

@SpringBootApplication
public class SpringbootJpaOneToManyDemoApplication implements CommandLineRunner {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {

		SpringApplication.run(SpringbootJpaOneToManyDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Unidirectional Mapping
//		Department department = new Department();
//		department.setName("COMPUTER");
//        departmentRepository.save(department);
//
//		Student student = new Student();
//		student.setDepartment(departmentRepository.findDepartmentByName("COMPUTER"));
//		student.setName("Anup");
//		student.setMobile(989911);
//		Student student1 = new Student();
//		student1.setDepartment(departmentRepository.findDepartmentByName("IT"));
//		student1.setName("John");
//		student1.setMobile(89774);
//		studentRepository.saveAll(Arrays.asList(student,student1));

		//Bi-directional mapping
		Department department1 = new Department();
		department1.setName("IT");
		Department department2 = new Department();
		department2.setName("AR");

		//Students list
		Student student = new Student();
		student.setName("Danny");
		student.setMobile(320092345);
		student.setDepartment(department1);
		Student student1 = new Student();
		student1.setName("Mark");
		student1.setMobile(338456723);
		student1.setDepartment(department1);
		Student student2= new Student();
		student2.setName("Beppe");
		student2.setMobile(330987645);
		student2.setDepartment(department2);
		Student student3= new Student();
		student3.setName("Ludovica");
		student3.setMobile(335786543);
		student3.setDepartment(department2);

		department1.setStudentList(Arrays.asList(student,student1));
		department2.setStudentList(Arrays.asList(student2, student3));
//		department1.getStudentList().add(student);
//		department1.getStudentList().add(student1);

		departmentRepository.save(department1);
		departmentRepository.save(department2);
		
//
//		//Get the list of students from department
//		Department department = departmentRepository.findDepartmentById(1l);
//
//		for(Student s : department.getStudentList())
//			System.out.println(s);



	}
}

