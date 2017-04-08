package com.javastud.springmvcweb.service;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class JUnitTestCase {

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void empty() {
		int[] a = new int[5];
		a[10] = 200;

		Assert.fail("Expected an IndexOutOfBoundsException to be thrown");
	}
	
	@Test
	public void bcryptPassword(){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = encoder.encode("admin");
		System.out.println("user : admin, password: " + password);
		assertTrue(encoder.matches("admin", password));
		
		System.out.println(encoder.encode("bob"));
		
	}

}
