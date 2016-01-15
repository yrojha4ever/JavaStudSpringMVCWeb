package com.javastud.springmvcweb.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.javastud.springmvcweb.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public User getUser(Long id) {
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, id);
		session.close();
		return user;
	}

}
