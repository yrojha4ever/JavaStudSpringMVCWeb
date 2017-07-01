package com.javastud.springmvcweb.dao;

import com.javastud.springmvcweb.model.Address;

public interface AddressDao {
	void insertUpdate(Address address);
	Address get(Long id);
}
