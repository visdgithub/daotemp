package com.istarindia.apps.dao;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Address entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "address", schema = "public")

public class Address implements java.io.Serializable {

	// Fields

	private Integer id;
	private Pincode pincode;
	private String addressline1;
	private String addressline2;
	private Set<Organization> organizations = new HashSet<Organization>(0);
	private Set<Student> students = new HashSet<Student>(0);

	// Constructors

	/** default constructor */
	public Address() {
	}

	/** minimal constructor */
	public Address(Pincode pincode, String addressline1, String addressline2) {
		this.pincode = pincode;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
	}

	/** full constructor */
	public Address(Pincode pincode, String addressline1, String addressline2, Set<Organization> organizations,
			Set<Student> students) {
		this.pincode = pincode;
		this.addressline1 = addressline1;
		this.addressline2 = addressline2;
		this.organizations = organizations;
		this.students = students;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pincode_id", nullable = false)

	public Pincode getPincode() {
		return this.pincode;
	}

	public void setPincode(Pincode pincode) {
		this.pincode = pincode;
	}

	@Column(name = "addressline1", nullable = false)

	public String getAddressline1() {
		return this.addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	@Column(name = "addressline2", nullable = false)

	public String getAddressline2() {
		return this.addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "address")

	public Set<Organization> getOrganizations() {
		return this.organizations;
	}

	public void setOrganizations(Set<Organization> organizations) {
		this.organizations = organizations;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "address")

	public Set<Student> getStudents() {
		return this.students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}