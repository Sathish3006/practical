package com.lm.model;

import javax.persistence.*;

@Entity
@Table(name="leavedata")
public class LeavePage {
	@Id
	@Column(name="rollno")
	private String rollno;
	@Column(name="totaldays")
	private String tdays;
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getTdays() {
		return tdays;
	}
	public void setTdays(String tdays) {
		this.tdays = tdays;
	}
	
}
