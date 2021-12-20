package com.greatlearning.CollegeFestEvent.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// Create the entity by adding all the required annotations and getters/setter methods.
@Entity
@Table(name="students")
@Getter
@Setter
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "department")
	private String department;

	@Column(name = "country")
	private String country;

	public Student(String name, String department, String country) {
		this.name = name;
		this.department = department;
		this.country = country;
	}


}
