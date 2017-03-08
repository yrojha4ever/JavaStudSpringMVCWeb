package com.javastud.springmvcweb.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.javastud.springmvcweb.dao.StudentDao;
import com.javastud.springmvcweb.model.Student;

@RestController
@RequestMapping("api/rest")
public class StudentRestController {

	private static final Logger logger = LoggerFactory.getLogger(StudentRestController.class);

	@Autowired
	private StudentDao studentDao;

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public ResponseEntity<List<Student>> studGetALL() {
		logger.info("Fetching data from db..");
		List<Student> studList = studentDao.getAll();

		// Sort it: TODO: sort students by Name: Normal way
		/*Collections.sort(studList, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getFirstName().compareTo(o2.getFirstName());
			}
		});*/

		Collections.sort(studList, (Student o1, Student o2) -> o1.getFirstName().compareTo(o2.getFirstName()));

		ResponseEntity<List<Student>> resp = new ResponseEntity<>(studList, HttpStatus.OK);
		return resp;
	}

	@RequestMapping(value = "/currency", method = RequestMethod.GET)
	public ResponseEntity<String> getTodayRate() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> resp = restTemplate.getForEntity("http://api.fixer.io/latest?base=USD", String.class);
		return resp;
	}
}
