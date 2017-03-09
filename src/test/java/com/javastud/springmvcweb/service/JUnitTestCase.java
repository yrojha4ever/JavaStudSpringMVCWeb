package com.javastud.springmvcweb.service;

import org.junit.Assert;
import org.junit.Test;

public class JUnitTestCase {

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void empty() {
		int[] a = new int[5];
		a[10] = 200;

		Assert.fail("Expected an IndexOutOfBoundsException to be thrown");
	}

}
