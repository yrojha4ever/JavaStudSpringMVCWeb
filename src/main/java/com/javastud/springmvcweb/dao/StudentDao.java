package com.javastud.springmvcweb.dao;

import java.util.List;

import com.javastud.springmvcweb.model.Student;

public interface StudentDao {
	void insertUpdate(Student student);
	List<Student> getAll();
	Student get(Long id);
	void delete(Long id);
}
