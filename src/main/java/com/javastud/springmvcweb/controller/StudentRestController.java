package com.javastud.springmvcweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class StudentRestController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "";
	}
}
