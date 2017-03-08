package com.javastud.springmvcweb.java8.datatime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * java.time package Old date time:
 * 
 * Not thread safe \n Poor design Difficult \n time zone handling
 * 
 * @author ojhay
 *
 */
public class Java8DateTimeTest {
	public static void main(String[] args) {

		/**
		 * LocalDate/LocalTime and LocalDateTime classes simplify the
		 * development where timezones are not required.
		 */

		// Get the current date and time
		// ERROR: LocalDateTime currentTime = new LocalDateTime();
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("Current DateTime: " + currentTime);
		System.out.println(currentTime.getDayOfWeek());

		LocalDate date1 = currentTime.toLocalDate();
		System.out.println("date1: " + date1);

		// 12 december 2014
		LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
		System.out.println("date3: " + date3);

		// 22 hour 15 minutes
		LocalTime date4 = LocalTime.of(22, 15);
		System.out.println("date4: " + date4);

		// parse a string
		LocalTime date5 = LocalTime.parse("20:15:30");
		System.out.println("date5: " + date5);

		System.out.println("-----------Zoned Date-Time API------------");
		/**
		 * Backward Compatibility A toInstant() method is added to the original
		 * Date and Calendar objects, which can be used to convert them to the
		 * new Date-Time API. Use an ofInstant(Insant,ZoneId) method to get a
		 * LocalDateTime or ZonedDateTime object.
		 */
		// Get the current date
		Date currentDate = new Date();
		System.out.println("Current date: " + currentDate);

		// Get the instant of current date in terms of milliseconds
		Instant now = currentDate.toInstant();
		ZoneId currentZone = ZoneId.systemDefault();

		LocalDateTime localDateTime = LocalDateTime.ofInstant(now, currentZone);
		System.out.println("Local date: " + localDateTime);

		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, currentZone);
		System.out.println("Zoned date: " + zonedDateTime);
		System.out.println(ZonedDateTime.now());

	}
}
