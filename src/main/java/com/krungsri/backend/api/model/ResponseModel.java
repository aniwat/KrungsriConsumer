package com.krungsri.backend.api.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "response")
public class ResponseModel {
	
	private String code;
	private String description;
	
	@JsonInclude(Include.NON_NULL)
	private ArrayList<String> systemMessage;
	
	public ResponseModel() {
		super();
	}
	
	public ResponseModel(ErrorCode errorCode) {
		super();
		this.code = errorCode.getCode();
		this.description = errorCode.getDescription();
	}
	
	public ResponseModel(String code, String description, ArrayList<String> systemMessage) {
		super();
		this.code = code;
		this.description = description;
		this.systemMessage = systemMessage;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ArrayList<String> getSystemMessage() {
		return systemMessage;
	}
	
	public void setSystemMessage(ArrayList<String> systemMessage) {
		this.systemMessage = systemMessage;
	}
	
	@Override
	public String toString() {
		return "ResponseModel [code=" + code + ", description=" + description + ", systemMessage=" + systemMessage + "]";
	}
	
}
