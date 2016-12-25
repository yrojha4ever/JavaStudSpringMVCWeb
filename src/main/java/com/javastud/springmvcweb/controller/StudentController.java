package com.javastud.springmvcweb.controller;

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
@RequestMapping(value = "/stud")
public class StudentController {

	@Autowired
	private StudentDao studentDao;

	@RequestMapping(method = RequestMethod.GET)
	public String studGET(Model model) {

		model.addAttribute("student", new Student());
		model.addAttribute("studentList", studentDao.getAll());

		return "studentForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String studPOST(Model model, @ModelAttribute Student student) {
		// Save data in db.
		studentDao.insertUpdate(student);

		model.addAttribute("student", new Student());
		model.addAttribute("studentList", studentDao.getAll());

		return "studentForm";
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public String editStud(@PathVariable("id") Long id, Model model) {
		Student stud = studentDao.get(id);

		model.addAttribute("student", stud);
		model.addAttribute("studentList", studentDao.getAll());

		return "studentForm";
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.POST)
	public String editStudPOST(@ModelAttribute Student student) {
		// Save data in db.
		studentDao.insertUpdate(student);
		return "redirect:/stud";
	}
	
	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	public String deleteStud( @PathVariable("id") Long id ){
		studentDao.delete(id);
		return "redirect:/stud";
	}

}
