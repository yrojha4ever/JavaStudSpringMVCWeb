package com.javastud.springmvcweb.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javastud.springmvcweb.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<Student> getAll() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Student.class);
		List<Student> students = (List<Student>) criteria.list();
		session.close();
		return students;
	}

	@Override
	@Transactional
	public Long insert(Student student) {
		Session session = sessionFactory.getCurrentSession();
		Long id = (Long) session.save(student);
		return id;
	}

}
