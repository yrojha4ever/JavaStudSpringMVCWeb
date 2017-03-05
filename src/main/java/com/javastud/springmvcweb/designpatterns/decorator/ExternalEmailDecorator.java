package com.javastud.springmvcweb.designpatterns.decorator;

public class ExternalEmailDecorator extends EmailDecorator {
	private String content;

	public ExternalEmailDecorator(IEmail basicEmail) {
		originalEmail = basicEmail;
	}

	@Override
	public String getContents() {
		// secure original
		content = addDisclaimer(originalEmail.getContents());
		return content;
	}

	private String addDisclaimer(String message) {
		// append company disclaimer to message
		return message + "\n Company Disclaimer";
	}
}
