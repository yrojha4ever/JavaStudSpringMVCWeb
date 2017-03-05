package com.javastud.springmvcweb.designpatterns.decorator;

public abstract class EmailDecorator implements IEmail {
	// wrapped component
	IEmail originalEmail;
}
