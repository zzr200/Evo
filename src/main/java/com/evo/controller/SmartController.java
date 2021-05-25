package com.evo.controller;

import com.evo.dao.DepartmentRepository;
import com.evo.dao.StudentRepository;
import com.evo.model.Department;
import com.evo.model.GetJson;
import com.evo.model.Payload;
import com.evo.model.Student;
import com.evo.service.DepartmentService;
import com.evo.service.StudentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class SmartController {

	@Autowired
	StudentService studentService;

	@Autowired
	DepartmentService departmentService;

	private static final Logger log = LoggerFactory.getLogger(SmartController.class);

	@GetMapping("/all")
	public GetJson all() {
		// servizi mock
		Payload pay = new Payload();
		pay.setBackhaulingFibraOttica(100);
		pay.setBackhaulingPonteRadio(75);
		pay.setBackhaulingRame(0);
		pay.setDaLavoareExtra(0);
		pay.setDaLavoarePev(0);
		pay.setInLavorazioneExtra(0);
		pay.setInLavorazionePev(0);
		pay.setLavoratiExtra(0);
		pay.setLavoratiPev(0);

		GetJson jj = new GetJson();

		jj.setResult("Success");
		jj.setPayload(pay);
		jj.setTotaleElementi(3);

		log.info("--------------------------------");
		log.info("Adesso si restituiscono servizi mock");
		log.info("--------------------------------");
		return jj;
	}

	@RequestMapping(value = "/studentList", method = RequestMethod.GET)
	public @ResponseBody List<Student> getStudents() {
		return studentService.getStudents();
	}

	@PostMapping("/saveStudent/{deptName}")
	public String saveStudent(@RequestBody List<Student> studentList, @PathVariable String deptName) {
		try {
			Department dept = departmentService.findDepartment(deptName.toUpperCase());

			for (Student student : studentList)
				student.setDepartment(dept);

			studentService.saveStudent(studentList);
			return "Student saved successfully..";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "Error in saving Student ..";
		}
	}
	
	@RequestMapping(value = "/cercaStudente", method = RequestMethod.GET)
	public @ResponseBody String findStudent(@RequestParam String StudentName) {
		log.info("-------Studente + Dipartimento");
		Student stud=departmentService.findStudent(StudentName);
		
		Department dep=stud.getDepartment();
		String restituzione=stud.getName()+" "+stud.getMobile()+" "+dep.getName();
		return restituzione;
	}
}
