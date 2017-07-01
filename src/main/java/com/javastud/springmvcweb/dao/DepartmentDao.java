package com.javastud.springmvcweb.dao;

import java.util.List;

import com.javastud.springmvcweb.model.Department;

public interface DepartmentDao {
	List<Department> getAll();
	Department get(Long id);
}
