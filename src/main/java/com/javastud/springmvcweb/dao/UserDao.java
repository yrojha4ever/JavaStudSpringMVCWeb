package com.javastud.springmvcweb.dao;

import com.javastud.springmvcweb.model.User;

public interface UserDao {
	public User getUser(Long id);

	// Using Jdbc Template
	public boolean validateUser(User uesr);
}
