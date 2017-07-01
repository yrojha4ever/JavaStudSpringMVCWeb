package com.javastud.springmvcweb.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "dept")
@Getter 
@Setter
@ToString(exclude ={"employees"})
public class Department {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "departments", cascade = CascadeType.ALL)
	@Fetch (FetchMode.SELECT)
	public List<Employee> employees;

	public void addEmployee(Employee employee) {
		employee.getDepartments().add(this);
		this.employees.add(employee);
	}

}
