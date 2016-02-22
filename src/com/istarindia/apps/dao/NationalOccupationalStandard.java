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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * NationalOccupationalStandard entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "national_occupational_standard", schema = "public")

public class NationalOccupationalStandard implements java.io.Serializable {

	// Fields

	private Integer id;
	private QualificationPack qualificationPack;
	private String code;
	private String title;
	private Set<LearningObjective> learningObjectives = new HashSet<LearningObjective>(0);

	// Constructors

	/** default constructor */
	public NationalOccupationalStandard() {
	}

	/** minimal constructor */
	public NationalOccupationalStandard(QualificationPack qualificationPack, String code, String title) {
		this.qualificationPack = qualificationPack;
		this.code = code;
		this.title = title;
	}

	/** full constructor */
	public NationalOccupationalStandard(QualificationPack qualificationPack, String code, String title,
			Set<LearningObjective> learningObjectives) {
		this.qualificationPack = qualificationPack;
		this.code = code;
		this.title = title;
		this.learningObjectives = learningObjectives;
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
	@JoinColumn(name = "qualification_pack_id", nullable = false)

	public QualificationPack getQualificationPack() {
		return this.qualificationPack;
	}

	public void setQualificationPack(QualificationPack qualificationPack) {
		this.qualificationPack = qualificationPack;
	}

	@Column(name = "code", nullable = false)

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "title", nullable = false)

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "national_occupational_standard_learning_objective", schema = "public", joinColumns = {
			@JoinColumn(name = "national_occupational_standardid", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "learning_objectiveid", nullable = false, updatable = false) })

	public Set<LearningObjective> getLearningObjectives() {
		return this.learningObjectives;
	}

	public void setLearningObjectives(Set<LearningObjective> learningObjectives) {
		this.learningObjectives = learningObjectives;
	}

}