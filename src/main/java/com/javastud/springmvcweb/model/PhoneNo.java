package com.javastud.springmvcweb.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "phone_no")
@Getter 
@Setter
@ToString(exclude ={"employee"})
public class PhoneNo {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "number")
	private String number;

	// 2. Many to One mapping. Many mobile no can be used by One Employee.
	// Required:ManyToOne is compulsory but OneToMany is not Compulsory.
	// If we have both that is called Bidirectional relation.
	@ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	public void addEmployee(Employee employee) {
		employee.getPhoneNos().add(this);
		this.setEmployee(employee);
	}

	
}
