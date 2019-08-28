package com.krungsri.backend.api.model;

public enum ErrorCode {
	
	SUCCESS("00", "Success"), 
	INVALID_REQUEST("10", "Invalid request"), 
	USER_NOT_FOUND("21", "User not found"),
	USER_DUPLICATED("22", "User duplicated");
	
	private final String code;
	private final String description;
	
	private ErrorCode(String code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getCode() {
		return code;
	}
	
	@Override
	public String toString() {
		return code + ": " + description;
	}
	
}
