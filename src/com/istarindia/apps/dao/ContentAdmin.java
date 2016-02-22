package com.istarindia.apps.dao;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;

/**
 * ContentAdmin entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "content_admin", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "email") )

public class ContentAdmin extends IstarUser {

	
	private Set<Cmsession> cmsessions = new HashSet<Cmsession>(0);

	// Constructors

	/** default constructor */
	public ContentAdmin() {
	}

	

	// Property accessors
	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contentAdmin")

	public Set<Cmsession> getCmsessions() {
		return this.cmsessions;
	}

	public void setCmsessions(Set<Cmsession> cmsessions) {
		this.cmsessions = cmsessions;
	}

}