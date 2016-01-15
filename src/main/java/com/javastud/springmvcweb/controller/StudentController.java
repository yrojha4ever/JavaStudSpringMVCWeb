package com.javastud.springmvcweb.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javastud.springmvcweb.dao.StudentDao;
import com.javastud.springmvcweb.model.Student;

@Controller
@RequestMapping("/stud")
public class StudentController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentDao studentDao;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		logger.info("GET: stud");
		model.addAttribute("student", new Student());
		
		List<Student> studList = studentDao.getAll();
		model.addAttribute("studentList", studList);
		
		return "studentForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String studFormPost(Model model, @ModelAttribute Student student){
		logger.info("POST: stud: " + student);
		Long id = studentDao.insert(student);
		model.addAttribute("student", student);
		
		List<Student> studList = studentDao.getAll();
		model.addAttribute("studentList", studList);
		return "studentForm";
	}
	

	//Only For TESTING..
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getStudent(@PathVariable("id") int id, Model model) {

		model.addAttribute("studId", id);
		System.out.println("Student Id is: " + id);

		model.addAttribute("richc", Arrays.asList("USA", "Canada", "UK"));

		return "studentForm";
	}

	@RequestMapping(value = "/{id}/rollno/{rn}", method = RequestMethod.GET)
	public String getStudent(@PathVariable("id") int id, @PathVariable("rn") String rn, Model model) {

		model.addAttribute("studId", id);
		model.addAttribute("rollNo", rn);
		model.addAttribute("richc", Arrays.asList("USA", "Canada", "UK"));

		return "studentForm";
	}

}
