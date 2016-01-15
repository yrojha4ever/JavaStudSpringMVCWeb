package com.javastud.springmvcweb.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class JdbcTemplateService {

	@Autowired
	private DataSource dataSource;

	public String getUserName(Long id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String username = jdbcTemplate.queryForObject("select username from user where id = ?", String.class, id);
		return username;
	}

}
