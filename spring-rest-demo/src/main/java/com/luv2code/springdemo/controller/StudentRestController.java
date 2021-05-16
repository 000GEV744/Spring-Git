package com.luv2code.springdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	@GetMapping("/students")
	public List<Student> showStudents(){
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("Anuj", "Singh"));
		studentList.add(new Student("Vivek", "Shukla"));
		studentList.add(new Student("Vikram", "Singh"));
		studentList.add(new Student("Ram", "Patel"));
		studentList.add(new Student("Chad", "Dubey"));
		
		return studentList;
	}
}
