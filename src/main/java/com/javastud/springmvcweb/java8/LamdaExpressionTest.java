package com.javastud.springmvcweb.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.javastud.springmvcweb.model.Student;

//http://winterbe.com/posts/2014/03/16/java-8-tutorial/
public class LamdaExpressionTest {
	public static void main(String[] args) {
		sortBefore8();
	}

	public static void sortBefore8() {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		// Collections.sort(names); ASC

		/*Collections.sort(names, Collections.reverseOrder());

		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});*/
		
		Collections.sort(names,
				(String a, String b) -> b.compareTo(a)
		);

		System.out.println(names.toString());
	}
}
