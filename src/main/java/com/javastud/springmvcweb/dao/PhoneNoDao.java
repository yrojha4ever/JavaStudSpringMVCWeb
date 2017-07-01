package com.javastud.springmvcweb.dao;

import com.javastud.springmvcweb.model.PhoneNo;

public interface PhoneNoDao {
	PhoneNo get(Long id);
	Long save(PhoneNo phoneNo);
}
