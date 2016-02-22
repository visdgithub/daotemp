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
import org.hibernate.annotations.GenericGenerator;

/**
 * Presentaion entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "presentaion", schema = "public")

public class Presentaion extends Lesson {

	// Fields

	private Set<Slide> slides = new HashSet<Slide>(0);

	// Constructors

	/** default constructor */
	public Presentaion() {
	}

	/** minimal constructor */
	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "presentaion")

	public Set<Slide> getSlides() {
		return this.slides;
	}

	public void setSlides(Set<Slide> slides) {
		this.slides = slides;
	}

}