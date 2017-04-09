package com.javastud.springmvcweb.designpatterns;

import java.time.LocalDate;

public class BuilderPatternExample {
	public static void main(String[] args) {
		User user = User.builder()
						.name("RAM")
						.age(20)
						.email("ram@gmail.com")
						.build();
		System.out.println(user);
		
		
		Employee emp = Employee.builder().id(5).name("Ram").address("KTM").birthDate(LocalDate.of(1990, 11, 17)).build();
		System.out.println(emp);
		
	}
	
}
