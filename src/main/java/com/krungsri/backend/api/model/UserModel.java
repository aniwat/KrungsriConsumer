package com.krungsri.backend.api.model;

import java.math.BigDecimal;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

//@JsonPropertyOrder({ "name", "id" })
@JsonRootName(value = "user")
public class UserModel {
	
	// @JsonIgnore
	@JsonProperty("id")
	@JsonInclude(Include.NON_DEFAULT)
	private int userId;
	
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String address;
	private String road;
	private String subDistrict; // ตำบล, แขวง
	private String district; // อำเภอ, เขต
	private String province;
	private String zipcode;
	private String phoneNumber;
	private BigDecimal salary;
	private Date registeredAt;
	
	@JsonInclude(Include.NON_NULL)
	private String referenceCode;
	
	public UserModel() {
		super();
	}
	
	public UserModel(int userId, String username, String password, String firstname, String lastname, String address, String road, String subDistrict, String district, String province, String zipcode,
			String phoneNumber, BigDecimal salary, Date registeredAt, String referenceCode) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.road = road;
		this.subDistrict = subDistrict;
		this.district = district;
		this.province = province;
		this.zipcode = zipcode;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
		this.registeredAt = registeredAt;
		this.referenceCode = referenceCode;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getRoad() {
		return road;
	}
	
	public void setRoad(String road) {
		this.road = road;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getSubDistrict() {
		return subDistrict;
	}
	
	public void setSubDistrict(String subDistrict) {
		this.subDistrict = subDistrict;
	}
	
	public String getDistrict() {
		return district;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public String getProvince() {
		return province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getZipcode() {
		return zipcode;
	}
	
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public BigDecimal getSalary() {
		return salary;
	}
	
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
	public Date getRegisteredAt() {
		return registeredAt;
	}
	
	public void setRegisteredAt(Date registeredAt) {
		this.registeredAt = registeredAt;
	}
	
	public String getReferenceCode() {
		return referenceCode;
	}
	
	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}
	
}
