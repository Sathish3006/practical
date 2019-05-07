package com.lm.model;

import javax.persistence.*;

@Entity
@Table(name="register")
public class Register {
	@Id
	@Column(name="rollno")
	private String rollno;
	@Column(name="name")
	private String name;
	@Column(name="type")
	private String type;
	@Column(name="pwd")
	private String pwd;
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
