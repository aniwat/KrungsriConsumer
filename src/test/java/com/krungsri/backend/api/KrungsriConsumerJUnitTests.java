package com.krungsri.backend.api;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;

import com.krungsri.backend.api.utils.PasswordUtils;

public class KrungsriConsumerJUnitTests {
	
	private static Properties props;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		props = new Properties();
		InputStream fileIn = props.getClass().getResourceAsStream("/application.properties");
		props.load(fileIn);
	}
	
	@Test
	public void passwordEncryption() {
		String salt = props.getProperty("password.salt");
		String password = "password";
		String encryptedPassword = PasswordUtils.generateSecurePassword(password, salt);
		
		System.out.println("Salt value = " + salt);
		
		// Print out protected password
		System.out.println("My encrypted password = " + encryptedPassword);
		
		boolean passwordMatch = PasswordUtils.verifyUserPassword(password, encryptedPassword, salt);
		
		if (passwordMatch) {
			System.out.println("Provided user password " + password + " is correct.");
		} else {
			System.out.println("Provided password is incorrect");
		}
		
		assertEquals(true, passwordMatch);
	}
	
}
