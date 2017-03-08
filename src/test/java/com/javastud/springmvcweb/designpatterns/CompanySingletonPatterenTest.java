package com.javastud.springmvcweb.designpatterns;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class CompanySingletonPatterenTest {

	@Test
	public void testCompanyEqual() {
		Company comp1 = Company.getInstance();
		Company comp2 = Company.getInstance();
		
		//check not null
		Assert.assertNotNull(comp1);

		//check equals
		assertEquals(comp1.getName(), "NGSOFT");
		assertEquals(comp2.getName(), "NGSOFT");
		
		Assert.assertSame(comp1, comp2);
		
		Assert.assertFalse("Company name is blank: ", comp1.getName().equals("NEPAL"));
		
	}

}
