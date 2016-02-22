package com.istarindia.apps.dao;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;


/**
 * Organization entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "organization", schema = "public")
@Inheritance(strategy = InheritanceType.JOINED)
public class Organization implements java.io.Serializable {

	// Fields

	private Integer id;
	private Address address;
	private String name;
	private String orgType;

	// Constructors

	/** default constructor */
	public Organization() {
	}

	/** minimal constructor */
	public Organization(Address address, String name, String orgType) {
		this.address = address;
		this.name = name;
		this.orgType = orgType;
	}

	/** full constructor */
	public Organization(Address address, String name, String orgType, College college, Company company,
			Government government) {
		this.address = address;
		this.name = name;
		this.orgType = orgType;
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
	@JoinColumn(name = "address_id", nullable = false)

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name = "name", nullable = false)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "org_type", nullable = false)

	public String getOrgType() {
		return this.orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	
	

}