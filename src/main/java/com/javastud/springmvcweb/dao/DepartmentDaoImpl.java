package com.javastud.springmvcweb.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javastud.springmvcweb.model.Department;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Department> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Department.class);
		return (List<Department>) criteria.list();
	}

	@Override
	@Transactional
	public Department get(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Department department = (Department) session.get(Department.class, id);
		return department;
	}

}
