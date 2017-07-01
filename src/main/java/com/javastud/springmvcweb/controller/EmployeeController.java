package com.javastud.springmvcweb.controller;

import java.beans.PropertyEditorSupport;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.javastud.springmvcweb.dao.AddressDao;
import com.javastud.springmvcweb.dao.DepartmentDao;
import com.javastud.springmvcweb.dao.EmployeeDao;
import com.javastud.springmvcweb.dao.PhoneNoDao;
import com.javastud.springmvcweb.model.Address;
import com.javastud.springmvcweb.model.Department;
import com.javastud.springmvcweb.model.Employee;
import com.javastud.springmvcweb.model.PhoneNo;
import com.javastud.springmvcweb.service.EmployeeService;
import com.javastud.springmvcweb.service.FileStorageService;

@Controller
@RequestMapping(value = "/emp")
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private FileStorageService fileStorageService;

	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private PhoneNoDao phoneNoDao;

	@Autowired
	private EmployeeService employeeService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(Employee.class, new PropertyEditorSupport() {
			@Override
			public String getAsText() {
				if (getValue() != null) {
					return "" + ((Employee) getValue()).getId();
				} else {
					return null;
				}
			}

			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				if (text != null && text.length() > 0) {
					setValue(employeeDao.get(Long.parseLong(text)));
				} else {
					setValue(null);
				}
			}
		});

		binder.registerCustomEditor(Department.class, new PropertyEditorSupport() {
			@Override
			public String getAsText() {
				if (getValue() != null) {
					return "" + ((Department) getValue()).getId();
				} else {
					return null;
				}
			}

			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				if (text != null && text.length() > 0) {
					setValue(departmentDao.get(Long.parseLong(text)));
				} else {
					setValue(null);
				}
			}
		});

		binder.registerCustomEditor(Address.class, new PropertyEditorSupport() {
			@Override
			public String getAsText() {
				if (getValue() != null) {
					return "" + ((Address) getValue()).getId();
				} else {
					return null;
				}
			}

			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				if (text != null && text.length() > 0) {
					setValue(addressDao.get(Long.parseLong(text)));
				} else {
					setValue(null);
				}
			}
		});

		binder.registerCustomEditor(PhoneNo.class, new PropertyEditorSupport() {
			@Override
			public String getAsText() {
				if (getValue() != null) {
					return "" + ((PhoneNo) getValue()).getId();
				} else {
					return null;
				}
			}

			@Override
			public void setAsText(String text) throws IllegalArgumentException {
				if (text != null && text.length() > 0) {
					setValue(phoneNoDao.get(Long.parseLong(text)));
				} else {
					setValue(null);
				}
			}
		});

		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView empGET(Model model) {
		ModelAndView mv = new ModelAndView("relation/employee");
		mv.addObject("employee", new Employee());

		List<Employee> empList = employeeDao.getAll();

		mv.addObject("employeeList", empList);
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String studPOST(@ModelAttribute Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/emp";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addStud(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("departments", departmentDao.getAll());
		return "relation/employeeDialog";
	}

	@RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
	public String editStud(@PathVariable("id") Long id, Model model) {
		model.addAttribute("employee", employeeDao.get(id));
		model.addAttribute("departments", departmentDao.getAll());
		return "relation/employeeDialog";
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
	public String deleteStud(@PathVariable("id") Long id) {
		employeeDao.delete(id);
		return "redirect:/emp";
	}

}
