package com.istarindia.apps.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Organization entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="college")
public class College extends Organization {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5997489420664252830L;
	private int maxStudents;

	@Column(name = "max_students", nullable = false)
	public int getMaxStudents() {
		return maxStudents;
	}

	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}
	
	

}