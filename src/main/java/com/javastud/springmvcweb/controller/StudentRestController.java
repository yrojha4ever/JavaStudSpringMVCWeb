package com.javastud.springmvcweb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javastud.springmvcweb.dao.StudentDao;
import com.javastud.springmvcweb.model.Student;

@RestController
@RequestMapping("api/rest")
public class StudentRestController {

private static final Logger logger = LoggerFactory.getLogger(StudentRestController.class);
	
	@Autowired
	private StudentDao studentDao;
	
	@RequestMapping(value="/students", method=RequestMethod.GET)
	public ResponseEntity<List<Student>> studGetALL(){
		logger.info("Fetching data from db..");
		List<Student> studList = studentDao.getAll();
		ResponseEntity<List<Student>> resp = new ResponseEntity<>(studList, HttpStatus.OK);
		return resp;
	}
	

	@RequestMapping(value="/currency", method=RequestMethod.GET)
	public ResponseEntity<String> getTodayRate(){
		String rate = "{\"base\":\"EUR\",\"date\":\"2016-11-03\",\"rates\":{\"AUD\":1.4434,\"BGN\":1.9558,\"BRL\":3.572,\"CAD\":1.4814,\"CHF\":1.0787,\"CNY\":7.4832,\"CZK\":27.021,\"DKK\":7.4406,\"GBP\":0.88658,\"HKD\":8.581,\"HRK\":7.514,\"HUF\":307.88,\"IDR\":14458.44,\"ILS\":4.2207,\"INR\":73.846,\"JPY\":114.25,\"KRW\":1266.04,\"MXN\":21.3426,\"MYR\":4.6331,\"NOK\":9.0575,\"NZD\":1.5134,\"PHP\":53.556,\"PLN\":4.3186,\"RON\":4.4988,\"RUB\":70.5482,\"SEK\":9.9068,\"SGD\":1.5332,\"THB\":38.691,\"TRY\":3.4431,\"USD\":1.1064,\"ZAR\":14.8945}}";
		ResponseEntity<String> resp = new ResponseEntity<>(rate, HttpStatus.OK);
		return resp;
	}
}
