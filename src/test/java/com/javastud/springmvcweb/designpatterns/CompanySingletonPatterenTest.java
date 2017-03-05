package com.javastud.springmvcweb.designpatterns;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompanySingletonPatterenTest {

	@Test
	public void testCompanyEqual() {
		Company comp1 = Company.getInstance();
		Company comp2 = Company.getInstance();

		assertEquals(comp1.getName(), "NGSOFT");
		assertEquals(comp2.getName(), "NGSOFT");

		assertEquals(comp1, comp2);
	}

}
