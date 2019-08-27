package com.krungsri.backend.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.krungsri.backend.api.model.UserModel;
import com.krungsri.backend.api.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.POST, value = "/user", consumes = "application/json")
	@ResponseBody
	public UserModel registerUser(@RequestBody UserModel model) {
		System.out.println("registerUser: ");
		model.setUserId(1);
		return model;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	@ResponseBody
	public String getUserInformation(@PathVariable("id") String userId) {
		System.out.println("getUserInformation: " + userId);
		return "";
	}
}
