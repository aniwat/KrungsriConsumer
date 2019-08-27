package com.krungsri.backend.api.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.krungsri.backend.api.model.UserModel;
import com.krungsri.backend.api.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.POST, value = "/user", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<UserModel> registerUser(@Valid @RequestBody UserModel user) {
		System.out.println("Call registerUser() ");
		System.out.println(user);
		
		UserModel userCreated = service.createCustomer(user);
		System.out.println(userCreated);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	@ResponseBody
	public ResponseEntity<UserModel> getUserInformation(@PathVariable("id") int userId) {
		System.out.println("Call getUserInformation() userId: " + userId);
		
		UserModel userRetrieved = service.retrieveCustomer(userId);
		
		if (userRetrieved == null) {
			return ResponseEntity.notFound().build();
		}
		
		System.out.println(userRetrieved);
		return ResponseEntity.status(HttpStatus.OK).body(userRetrieved);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
	
}
