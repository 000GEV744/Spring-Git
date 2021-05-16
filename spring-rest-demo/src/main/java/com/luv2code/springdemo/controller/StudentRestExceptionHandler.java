package com.luv2code.springdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

		//add an excption handler using @Exception Handler
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

		}
}
