package com.javastud.springmvcweb.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.util.AutoPopulatingList;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employee")
@Getter 
@Setter
@ToString(exclude ={"phoneNos, departments"})
public class Employee {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "birth_date")
	private Date birthDate;

	@Column(name = "avatar")
	private String avatar;

	@Transient
	private MultipartFile avatarFile;

	// 1. One To One Mapping. Employee has a Address.
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
	@JoinColumn(name = "address_id")
	private Address address;

	// Optional: 2. One To Many mapping.Employee have Many Mobile No.s
	// MappedBy: PhoneNo.java>employee Field.
	@OneToMany(mappedBy = "employee", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.DELETE})
	private List<PhoneNo> phoneNos = new AutoPopulatingList<>(new PhoneNoFactory(this));

	// 4. Many To Many mapping. Employee can Have Many Department and One
	// Department Can have Many Employees. NOTE: Write Join Column Line In only
	// One Place. Either in Employee.class or Department.class.
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch (FetchMode.SELECT)
	@JoinTable(name = "employee_dept", joinColumns = { @JoinColumn(name = "emp_id") }, inverseJoinColumns = {
			@JoinColumn(name = "dept_id") })
	private List<Department> departments = new AutoPopulatingList<>(new DepartmentFactory(this));

	class DepartmentFactory implements AutoPopulatingList.ElementFactory<Department>, Serializable {

		private static final long serialVersionUID = 1L;

		private Employee employee;

		public DepartmentFactory(Employee employee) {
			this.employee = employee;
		}

		public Department createElement(int index) {
			Department department = new Department();
			department.addEmployee(employee);
			return department;
		}
	}

	class PhoneNoFactory implements AutoPopulatingList.ElementFactory<PhoneNo>, Serializable {

		private static final long serialVersionUID = 1L;

		private Employee employee;

		public PhoneNoFactory(Employee employee) {
			this.employee = employee;
		}

		public PhoneNo createElement(int index) {
			PhoneNo phoneNo = new PhoneNo();
			phoneNo.addEmployee(employee);
			return phoneNo;
		}
	}

}