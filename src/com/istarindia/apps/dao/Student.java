package com.istarindia.apps.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "student", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "email") )

public class Student extends IstarUser {

	// Fields

	private Organization organization;
	private Address address;

	private String fatherName;
	private String motherName;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(IstarUser istarUser, String email, String name, String password, String userType, String fatherName,
			String motherName) {

		this.fatherName = fatherName;
		this.motherName = motherName;
	}

	/** full constructor */
	public Student(Organization organization, Address address, IstarUser istarUser, String email, String gender,
			Boolean isVerified, String istarAuthorizationToken, Long mobile, String name, String password,
			Boolean tokenExpired, String tokenVerified, String userType, String fatherName, String motherName) {
		this.organization = organization;
		this.address = address;

		this.fatherName = fatherName;
		this.motherName = motherName;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "organization_id")

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name = "father_name", nullable = false)

	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	@Column(name = "mother_name", nullable = false)

	public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

}