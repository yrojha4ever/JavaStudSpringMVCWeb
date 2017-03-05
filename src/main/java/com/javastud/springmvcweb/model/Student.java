package com.javastud.springmvcweb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "roll_no")
	private String rollNo;

	@Column(name = "college_name")
	private String collegeName;

	@Column(name = "subject")
	private String subject;

	@Column(name = "birth_date")
	private Date birthDate;

	@Column(name = "image_name")
	private String imageName;

	@Column(name = "fee")
	private Double fee;

	@Transient
	private MultipartFile file;

}
