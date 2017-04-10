package com.javastud.springmvcweb.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javastud.springmvcweb.dao.StudentDao;
import com.javastud.springmvcweb.model.Student;
import com.javastud.springmvcweb.service.FileStorageService;

@Controller
@RequestMapping(value = "/stud")
public class StudentController {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private FileStorageService fileStorageService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		formatter.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(formatter, true));
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView studGET(Model model) {

		ModelAndView mv = new ModelAndView("studentForm");
		
		mv.addObject("student", new Student());
		mv.addObject("studentList", studentDao.getAll());

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String studPOST(Model model, @ModelAttribute Student student) {

		saveStudent(student);

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
		saveStudent(student);
		return "redirect:/stud";
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	public String deleteStud(@PathVariable("id") Long id) {
		studentDao.delete(id);
		return "redirect:/stud";
	}

	private void saveStudent(Student student) {
		try {
			if (!student.getFile().isEmpty()) {
				student.setImageName(URLEncoder.encode(student.getFile().getOriginalFilename(), "UTF-8"));
				// Save file in drive
				fileStorageService.saveFile(student.getFile());
			}

			// Save data in db.
			studentDao.insertUpdate(student);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
