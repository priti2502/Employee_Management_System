package com.qsp.employee_management_system.exception;

import java.util.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.employee_management_system.util.ResponseStructure;
@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(PhoneNotFound.class)
	public ResponseEntity<ResponseStructure<String>> handlePhoneNotFound(PhoneNotFound ex)
	{
		ResponseStructure<String> s=new ResponseStructure<String>();
		s.setMessage(ex.getMessage());
		s.setStatus(HttpStatus.NOT_FOUND.value());
		s.setData("Phone number not found");
		return new ResponseEntity<ResponseStructure<String>>(s,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFound(IdNotFound ex)
	{
		ResponseStructure<String> s=new ResponseStructure<String>();
		s.setMessage(ex.getMessage());
		s.setStatus(HttpStatus.NOT_FOUND.value());
		s.setData("Id not found");
		return new ResponseEntity<ResponseStructure<String>>(s,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EmailNotFound.class)
	public ResponseEntity<ResponseStructure<String>> handleEmailNotFound(EmailNotFound ex)
	{
		ResponseStructure<String> s=new ResponseStructure<String>();
		s.setMessage(ex.getMessage());
		s.setStatus(HttpStatus.NOT_FOUND.value());
		s.setData("Email not found");
		return new ResponseEntity<ResponseStructure<String>>(s,HttpStatus.NOT_FOUND);
	}
	
	@Override
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		List<ObjectError> errors=ex.getAllErrors();	
		Map<String,String>map=new HashMap<String, String>();
	    for (ObjectError objectError : errors) {
	    FieldError error=(FieldError) objectError;
	    String name=error.getField();
        String message=error.getDefaultMessage();
        map.put(name, message);
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
		
	}

	

}
