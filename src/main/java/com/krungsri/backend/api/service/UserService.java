package com.krungsri.backend.api.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.krungsri.backend.api.model.UserModel;
import com.krungsri.backend.api.repository.UserRepository;
import com.krungsri.backend.api.repository.UserRepositoryImpl;
import com.krungsri.backend.api.utils.PasswordUtils;

@Service
public class UserService {
	
	private UserRepository repository;
	
	@Value("${password.salt}")
	private String salt;
	
	public UserService() {
		this.repository = new UserRepositoryImpl();
	}
	
	public UserModel createCustomer(UserModel user) {
		BigDecimal salary = user.getSalary();
		
		if (salary.doubleValue() > 50_000) {
			user.setMemberType("Platinum");
		} else if (salary.doubleValue() >= 30_000 && salary.doubleValue() <= 50_000) {
			user.setMemberType("Gold");
		} else {
			user.setMemberType("Silver");
		}
		
		Date now = Calendar.getInstance().getTime();
		user.setRegisteredAt(now);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String strNow = dateFormat.format(now);
		
		String phoneNumber = user.getPhoneNumber();
		String phoneNumberLast4Digit = phoneNumber.substring(phoneNumber.length() - 4, phoneNumber.length());
		user.setReferenceCode(strNow + phoneNumberLast4Digit);
		
		// Protect user's password. The generated value can be stored in DB.
		String encryptedPassword = PasswordUtils.generateSecurePassword(user.getPassword(), salt);
		user.setEncryptedPassword(encryptedPassword);
		
		return repository.save(user);
	}
	
	public UserModel retrieveCustomer(int userId) {
		return repository.findByUserId(userId);
	}
	
}
