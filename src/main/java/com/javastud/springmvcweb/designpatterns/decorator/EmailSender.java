package com.javastud.springmvcweb.designpatterns.decorator;

public class EmailSender {
	public void sendEmail(IEmail email) {
		// read the email to-address, to see if it's going outside of the
		// company if so decorate it
		ExternalEmailDecorator external = new ExternalEmailDecorator(email);
		String contents = external.getContents(); // send
		System.out.println(contents);
		// Send email

		int i = 0;
		for (;;) {
			System.out.print("Sending Email....  	"+ i + "%			\r" );
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (i++ == 10) {
				break;
			}
		}
	}
}
