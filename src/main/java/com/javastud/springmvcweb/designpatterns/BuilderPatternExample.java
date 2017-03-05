package com.javastud.springmvcweb.designpatterns;

public class BuilderPatternExample {
	public static void main(String[] args) {
		User user = User.UserBuilder()
						.name("RAM")
						.age(20)
						.email("ram@gmail.com")
						.build();
		System.out.println(user);
	}
}
