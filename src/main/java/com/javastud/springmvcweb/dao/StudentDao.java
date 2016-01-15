package com.javastud.springmvcweb.dao;

import java.util.List;

import com.javastud.springmvcweb.model.Student;

public interface StudentDao {
	public List<Student> getAll();
	
	public Long insert(Student student);
}
