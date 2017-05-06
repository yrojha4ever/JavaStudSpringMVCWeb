package com.javastud.springmvcweb.designpatterns.builder;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Employee {
	private int id;
	private String name;
	private String address;
	private LocalDate birthDate;
}
