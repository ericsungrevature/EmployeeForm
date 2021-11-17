package com.employee;
//create table employee(id integer primary key auto_increment, name char(20) not null unique, email char(20), gender enum('male','female'), country char(20));

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

@Entity
public class Employee {
	@Id
	private int id;
	@NaturalId
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String gender;
	@Column
	private String country;
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getGender() {return gender;}
	public void setGender(String gender) {this.gender = gender;}
	public String getCountry() {return country;}
	public void setCountry(String country) {this.country = country;}
}
