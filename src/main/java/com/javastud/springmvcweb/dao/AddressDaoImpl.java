package com.javastud.springmvcweb.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javastud.springmvcweb.model.Address;
import com.javastud.springmvcweb.model.Student;

@Repository
public class AddressDaoImpl implements AddressDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void insertUpdate(Address address) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(address);
	}

	@Override
	@Transactional
	public Address get(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Address address = (Address) session.get(Student.class, id);
		return address;
	}

}
