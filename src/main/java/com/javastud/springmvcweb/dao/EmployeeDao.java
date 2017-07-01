package com.javastud.springmvcweb.dao;

import java.util.List;

import com.javastud.springmvcweb.model.Employee;

public interface EmployeeDao {
	void insertUpdate(Employee employee);
	List<Employee> getAll();
	Employee get(Long id);
	void delete(Long id);
}
