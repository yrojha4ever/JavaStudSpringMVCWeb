package com.javastud.springmvcweb.service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ServiceUtils {

	public List<String> getCountries() {
		List<String> countries = Stream.of("Nepal", "Bhutan", "China", "Japan", "America").sorted()
				.collect(Collectors.toList());
		return countries;
	}

	public ZonedDateTime getCurrentUtcDateTime() {
		ZoneId utcTimeZone = ZoneId.of("Etc/UTC");
		ZonedDateTime zonedDateTime = ZonedDateTime.now(utcTimeZone);
		return zonedDateTime;
	}
	
	
}
