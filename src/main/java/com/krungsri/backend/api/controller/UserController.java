package com.krungsri.backend.api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import org.springframework.web.bind.annotation.RestController;

import com.krungsri.backend.api.model.ErrorCode;
import com.krungsri.backend.api.model.ResponseModel;
import com.krungsri.backend.api.model.UserModel;
import com.krungsri.backend.api.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.POST, value = "/user", consumes = "application/json")
	@ResponseBody
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserModel user) {
		System.out.println("Call registerUser() ");
		System.out.println(user);
		
		UserModel userCreated = service.createCustomer(user);
		System.out.println(userCreated);
		
		ResponseModel response = new ResponseModel(ErrorCode.SUCCESS);
		
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("response", response);
		map.put("user", userCreated);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(map);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	@ResponseBody
	public ResponseEntity<?> getUserInformation(@PathVariable("id") int userId) {
		System.out.println("Call getUserInformation() userId: " + userId);
		
		UserModel userRetrieved = service.retrieveCustomer(userId);
		
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		
		if (userRetrieved == null) {
			ResponseModel response = new ResponseModel(ErrorCode.USER_NOT_FOUND);
			map.put("response", response);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
		}
		
		System.out.println(userRetrieved);
		
		ResponseModel response = new ResponseModel(ErrorCode.SUCCESS);
		map.put("response", response);
		map.put("user", userRetrieved);
		
		return ResponseEntity.status(HttpStatus.OK).body(map);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		
		ResponseModel response = new ResponseModel(ErrorCode.INVALID_REQUEST);
		response.setSystemMessage(new ArrayList<String>(errors.values()));
		
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("response", response);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	
}
