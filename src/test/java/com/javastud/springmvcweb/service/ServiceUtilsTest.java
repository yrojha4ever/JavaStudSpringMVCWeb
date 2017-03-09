package com.javastud.springmvcweb.service;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;

import java.time.ZonedDateTime;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.DEFAULT) //NAME_ASCENDING
public class ServiceUtilsTest {

	private ServiceUtils serviceUtils;

	@BeforeClass
	public static void init() {
		System.out.println("Before class...");
	}

	@AfterClass
	public static void clean() {
		System.out.println("After class...");
	}

	@Before
	public void beforeMethod() {
		serviceUtils = new ServiceUtils();
		System.out.println("Before method...");
	}

	@After
	public void afterMethod() {
		System.out.println("after method..");
	}

	@Test
	public void testTimeZoneUtc() {
		ZonedDateTime currentDateTime = serviceUtils.getCurrentUtcDateTime();
		Assert.assertNotNull((currentDateTime));
		Assert.assertSame(currentDateTime.getZone().toString(), "Etc/UTC");
	}

	// Test Fail: how to ignore
	@Ignore
	@Test
	public void testSortNotEmpty() {
		Integer zero = 0; // Expected is <0> but: was <5>
		Assert.assertThat("array not empty", serviceUtils.getCountries().size(), is(zero));
	}

	@Test
	public void testSortedArrayItem() {
		Assert.assertThat(serviceUtils.getCountries(), hasItems("Nepal", "Bhutan"));
	}

}
