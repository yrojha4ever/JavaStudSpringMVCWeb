package com.javastud.springmvcweb.designpatterns.decorator;

//https://dzone.com/articles/design-patterns-decorator
public class DecoratorPatterenTest {
	public static void main(String[] args) {
		
		String content = "HI, This is John form Nepal , \n learning Decorator pattern.";
		
		IEmail email = new Email(content);
		
		EmailSender sender = new EmailSender();
		sender.sendEmail(email);
	}
}
