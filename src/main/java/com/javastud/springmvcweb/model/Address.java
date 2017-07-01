package com.javastud.springmvcweb.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class Address {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "zip")
	private String zip;

	@Column(name = "country")
	private String country;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "address")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	private Employee employee;
	

}
