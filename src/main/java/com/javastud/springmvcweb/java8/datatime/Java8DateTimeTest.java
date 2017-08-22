package com.javastud.springmvcweb.java8.datatime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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
		
		//OLD
		Date d = new Date();
		System.out.println(d);
		
		// Get the current date and time
		// ERROR: LocalDateTime currentTime = new LocalDateTime();
		LocalDateTime currentDTime = LocalDateTime.now();
		System.out.println("Current Date Time: " + currentDTime);
		System.out.println(currentDTime.getDayOfWeek());
		
		LocalDate date1 = currentDTime.toLocalDate();
		System.out.println("Date1: " + date1);
		
		LocalTime time1 = currentDTime.toLocalTime();
		System.out.println("Time1: " + time1);
		
		// 12 December 2014
		LocalDate date2 = LocalDate.of(2014, Month.DECEMBER, 12);
		System.out.println("Date of: " + date2);
		
		// 22 hour 15 minutes
		LocalTime time2 = LocalTime.of(22, 15);
		System.out.println("Time 2: " + time2);
		
		String timeStr = "20:15:30"; //"HH:mm:ss MM/dd/uuuu";
		LocalTime time3 = LocalTime.parse(timeStr, DateTimeFormatter.ofPattern("HH:mm:ss"));
		System.out.println("Formatted Time: " + time3);
		
		System.out.println("-----------Zoned Date-Time API------------");
		System.out.println(ZonedDateTime.now()); //Etc/UTC
		
		ZoneId currentZone = ZoneId.of("Asia/Kathmandu");
		System.out.println(ZonedDateTime.now(currentZone));
		
		/**
		 * Backward Compatibility A toInstant() method is added to the original
		 * Date and Calendar objects, which can be used to convert them to the
		 * new Date-Time API. Use an ofInstant(Insant,ZoneId) method to get a
		 * LocalDateTime or ZonedDateTime object.
		 */
		// Get the current date
		Date currentDate = new Date();
		System.out.println("Current date (old) :" + currentDate);
		
		// Get the instant of current date in terms of milliseconds
		Instant instant  = currentDate.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
		System.out.println("Local Date Time : " + localDateTime);
		
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, zone);
		System.out.println("Zoned Date Time: " + zonedDateTime);
		
	}
}
