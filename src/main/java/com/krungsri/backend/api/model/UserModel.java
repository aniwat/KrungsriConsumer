package com.krungsri.backend.api.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "user")
@JsonPropertyOrder({ "id" })
public class UserModel {
	
	// @JsonIgnore
	@JsonProperty("id")
	@JsonInclude(Include.NON_DEFAULT)
	private int userId;
	
	@NotBlank(message = "username is required")
	private String username;
	
	@NotBlank(message = "password is required")
	private String password;
	
	@JsonInclude(Include.NON_NULL)
	private String EncryptedPassword;
	
	@NotBlank(message = "firstname is required")
	private String firstname;
	
	@NotBlank(message = "lastname is required")
	private String lastname;
	
	@NotBlank(message = "address is required")
	private String address;
	
	private String road;
	
	@NotBlank(message = "subDistrict is required")
	private String subDistrict; // ตำบล, แขวง
	
	@NotBlank(message = "district is required")
	private String district; // อำเภอ, เขต
	
	@NotBlank(message = "province is required")
	private String province;
	
	@NotBlank(message = "zipcode is required")
	private String zipcode;
	
	@NotBlank(message = "phoneNumber is required")
	@Size(min = 10, max = 10)
	private String phoneNumber;
	
	@JsonInclude(Include.NON_DEFAULT)
	@DecimalMin(value = "15000.00", message = "Salary < 15,000")
	private BigDecimal salary;
	
	private Date registeredAt;
	
	@JsonInclude(Include.NON_NULL)
	private String memberType;
	
	@JsonInclude(Include.NON_NULL)
	private String referenceCode;
	
	public UserModel() {
		super();
	}
	
	public UserModel(int userId, String username, String password, String EncryptedPassword, String firstname, String lastname, String address, String road, String subDistrict,
	    String district, String province, String zipcode, String phoneNumber, BigDecimal salary, Date registeredAt, String memberType, String referenceCode) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.EncryptedPassword = EncryptedPassword;
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
		this.memberType = memberType;
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
	
	public String getEncryptedPassword() {
		return EncryptedPassword;
	}
	
	public void setEncryptedPassword(String encryptedPassword) {
		EncryptedPassword = encryptedPassword;
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
	
	public String getMemberType() {
		return memberType;
	}
	
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	
	public String getReferenceCode() {
		return referenceCode;
	}
	
	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}
	
	@Override
	public String toString() {
		return "UserModel [userId=" + userId + ", username=" + username + ", password=" + password + ", EncryptedPassword=" + EncryptedPassword + ", firstname=" + firstname
		    + ", lastname=" + lastname + ", address=" + address + ", road=" + road + ", subDistrict=" + subDistrict + ", district=" + district + ", province=" + province + ", zipcode="
		    + zipcode + ", phoneNumber=" + phoneNumber + ", salary=" + salary + ", registeredAt=" + registeredAt + ", memberType=" + memberType + ", referenceCode=" + referenceCode
		    + "]";
	}
	
}
