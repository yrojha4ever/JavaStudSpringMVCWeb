package com.javastud.springmvcweb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javastud.springmvcweb.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {

	@Resource
	private SessionFactory sessionFactory;

	/*
	 * @Resource public void setSessionFactory(SessionFactory sessionFactory) {
	 * this.sessionFactory = sessionFactory; }
	 */

	// Notice that spring declarative transaction management is applied by using
	// @Transactional annotation.
	// use: @Transactional. If not: call openSession() instead of
	// CurrentSession()
	// @Transactional
	@Override
	public List<Person> listPersons() {
		// If no transaction: use: Session session =
		// sessionFactory.openSession();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Person.class);
		List<Person> persons = (List<Person>) criteria.list();

		session.close();
		return persons;
	}

}
