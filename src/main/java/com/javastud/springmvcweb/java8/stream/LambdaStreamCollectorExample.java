package com.javastud.springmvcweb.java8.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaStreamCollectorExample {
	public static void main(String[] args) {

		List<Person> persons = Arrays.asList(new Person("Max", 18), new Person("Peter", 23), new Person("Mark", 33),
				new Person("David", 12));

		System.out.println(persons);

		// Sort no 1 way:
		// EEROR Collections.sort(persons); , because Person have no comparable
		// interface implemented, not good idea if you want to sort diff list in
		// diff way, alternate way? Annonymous class.

		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		System.out.println(persons);

		// Sort no 2 way: Lambda Expression.
		Collections.sort(persons, (Person a, Person b) -> a.name.compareTo(b.name));
		System.out.println(persons);

		//=======filter all the person with Name M=======================
		List<Person> filtered = persons
				.stream()
				.filter(p -> p.name.startsWith("M"))
				.collect(Collectors.toList());
		System.out.println(filtered);
	}

}
