package com.javastud.springmvcweb.dao;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javastud.springmvcweb.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Resource
	private SessionFactory sessionFactory;

	@Autowired
	private DataSource dataSource;

	@Override
	public User getUser(Long id) {
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, id);
		session.close();
		return user;
	}

	// Using Spring JdbcTemplate
	@Override
	public boolean validateUser(User uesr) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String query = "select username from user where username = '" + uesr.getUsername() + "' and password = '" + uesr.getPassword() + "'";
		try {

			String username = jdbcTemplate.queryForObject(query, String.class);
			if (null != username && username.equals(uesr.getUsername())) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
