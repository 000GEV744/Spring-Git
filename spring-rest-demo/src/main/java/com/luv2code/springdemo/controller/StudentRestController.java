package com.luv2code.springdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.HttpAccessor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;
	
	//define @PostContruct to load the student data ... only once when this bean is constructed.
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<Student>();
		theStudents.add(new Student("Anuj", "Singh"));
		theStudents.add(new Student("Vivek", "Shukla"));
		theStudents.add(new Student("Vikram", "Singh"));
		theStudents.add(new Student("Ram", "Patel"));
		theStudents.add(new Student("Chad", "Dubey"));
	}
	
	
	@GetMapping("/students")
	public List<Student> showStudents(){		
		return theStudents;
	}
	
	//define endpoint for "/students/{studentId}" = return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable(name = "studentId") int id) {
		//check the studentId against the list size
		if((id >= theStudents.size()) || (id<0)){
			throw new StudentNotFoundException("Student id not found - "+id);
		}
		return theStudents.get(id);
	}
	
	/*//add an excption handler using @Exception Handler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException  exc){
		
		//create a studentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		
		//return ResponseEntity
		return new ResponseEntity<StudentErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
	
	
	//add another exception handler ...  to catch any exception
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		
		//create a studentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
				
		//return ResponseEntity
		return new ResponseEntity<StudentErrorResponse>(error,HttpStatus.BAD_REQUEST);

	}*/
}
