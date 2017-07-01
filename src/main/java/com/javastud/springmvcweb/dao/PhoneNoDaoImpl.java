package com.javastud.springmvcweb.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javastud.springmvcweb.model.PhoneNo;

@Repository
public class PhoneNoDaoImpl implements PhoneNoDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public PhoneNo get(Long id) {
		Session session = sessionFactory.getCurrentSession();
		PhoneNo phoneNo = (PhoneNo) session.get(PhoneNo.class, id);
		return phoneNo;
	}

	@Override
	@Transactional
	public Long save(PhoneNo phoneNo) {
		Session session = sessionFactory.getCurrentSession();
		Long id = (Long) session.save(phoneNo);
		return id;
	}

}
