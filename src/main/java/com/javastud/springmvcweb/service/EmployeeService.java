package com.javastud.springmvcweb.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.javastud.springmvcweb.dao.AddressDao;
import com.javastud.springmvcweb.dao.DepartmentDao;
import com.javastud.springmvcweb.dao.EmployeeDao;
import com.javastud.springmvcweb.dao.PhoneNoDao;
import com.javastud.springmvcweb.model.Address;
import com.javastud.springmvcweb.model.Employee;
import com.javastud.springmvcweb.model.PhoneNo;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private FileStorageService fileStorageService;

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private DepartmentDao departmentDao;

	@Autowired
	private AddressDao addressDao;

	@Autowired
	private PhoneNoDao phoneNoDao;
	
	public void saveEmployee(Employee employee) {
		try {
			MultipartFile file = employee.getAvatarFile();
			if (!file.isEmpty()) {
				employee.setAvatar(URLEncoder.encode(file.getOriginalFilename(), "UTF-8"));
				// Save file in drive
				fileStorageService.saveFile(file);
			}

			// Save data in db.
			/**
			 * 1. Employee -> Phone NO have one to many relationship. Phone No
			 * have extra columen called employee_id, we should set its value
			 * onece phone no is saved.
			 */
			for (PhoneNo phoneNo : employee.getPhoneNos()) {
				//phoneNoDao.save(phoneNo);
				// Set Employee because, employee is not yet saved so,
				// it have no id avaiable at moment, but employeedao.merge will
				// update phoneno table employee_id
				phoneNo.setEmployee(employee);
			}

			/**
			 * No2. Employee->Address : one to one relation so, we there is no
			 * emplyee id need to set in address table. but Employee table have
			 * address_id field that will be updated once address is saved
			 */

			/**
			 * No 3. Employee -> Departments: Many to Many relation. As
			 * department is alrady saved on we used in combo box. so we should
			 * just set employee in department table but that is automatically
			 * done by AutopopulatingList used in entity. Also
			 * CustomBeanRegister, which fetch whole record from db by id and
			 * set it in employee department.
			 */
			Address addrs = employee.getAddress();
			addrs.setEmployee(employee);
			
			employeeDao.insertUpdate(employee);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
}
