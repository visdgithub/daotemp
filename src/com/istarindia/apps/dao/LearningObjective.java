package com.istarindia.apps.dao;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * LearningObjective entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "learning_objective", schema = "public")

public class LearningObjective implements java.io.Serializable {

	// Fields

	private Integer id;
	private String objType;
	private String title;
	private Set<Lesson> lessons = new HashSet<Lesson>(0);
	private Set<NationalOccupationalStandard> nationalOccupationalStandards = new HashSet<NationalOccupationalStandard>(
			0);

	// Constructors

	/** default constructor */
	public LearningObjective() {
	}

	/** minimal constructor */
	public LearningObjective(String objType, String title) {
		this.objType = objType;
		this.title = title;
	}

	/** full constructor */
	public LearningObjective(String objType, String title, Set<Lesson> lessons,
			Set<NationalOccupationalStandard> nationalOccupationalStandards) {
		this.objType = objType;
		this.title = title;
		this.lessons = lessons;
		this.nationalOccupationalStandards = nationalOccupationalStandards;
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

	@Column(name = "obj_type", nullable = false)

	public String getObjType() {
		return this.objType;
	}

	public void setObjType(String objType) {
		this.objType = objType;
	}

	@Column(name = "title", nullable = false)

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "learningObjectives")

	public Set<Lesson> getLessons() {
		return this.lessons;
	}

	public void setLessons(Set<Lesson> lessons) {
		this.lessons = lessons;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "learningObjectives")

	public Set<NationalOccupationalStandard> getNationalOccupationalStandards() {
		return this.nationalOccupationalStandards;
	}

	public void setNationalOccupationalStandards(Set<NationalOccupationalStandard> nationalOccupationalStandards) {
		this.nationalOccupationalStandards = nationalOccupationalStandards;
	}

}