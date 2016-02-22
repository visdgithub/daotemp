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
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * QualificationPack entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "qualification_pack", schema = "public")

public class QualificationPack implements java.io.Serializable {

	// Fields

	private Integer id;
	private String jobrole;
	private String qpCode;
	private Set<LearningOutcome> learningOutcomes = new HashSet<LearningOutcome>(0);
	private Set<NationalOccupationalStandard> nationalOccupationalStandards = new HashSet<NationalOccupationalStandard>(
			0);

	// Constructors

	/** default constructor */
	public QualificationPack() {
	}

	/** minimal constructor */
	public QualificationPack(String jobrole, String qpCode) {
		this.jobrole = jobrole;
		this.qpCode = qpCode;
	}

	/** full constructor */
	public QualificationPack(String jobrole, String qpCode, Set<LearningOutcome> learningOutcomes,
			Set<NationalOccupationalStandard> nationalOccupationalStandards) {
		this.jobrole = jobrole;
		this.qpCode = qpCode;
		this.learningOutcomes = learningOutcomes;
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

	@Column(name = "jobrole", nullable = false)

	public String getJobrole() {
		return this.jobrole;
	}

	public void setJobrole(String jobrole) {
		this.jobrole = jobrole;
	}

	@Column(name = "qp_code", nullable = false)

	public String getQpCode() {
		return this.qpCode;
	}

	public void setQpCode(String qpCode) {
		this.qpCode = qpCode;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "qualificationPack")

	public Set<LearningOutcome> getLearningOutcomes() {
		return this.learningOutcomes;
	}

	public void setLearningOutcomes(Set<LearningOutcome> learningOutcomes) {
		this.learningOutcomes = learningOutcomes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "qualificationPack")

	public Set<NationalOccupationalStandard> getNationalOccupationalStandards() {
		return this.nationalOccupationalStandards;
	}

	public void setNationalOccupationalStandards(Set<NationalOccupationalStandard> nationalOccupationalStandards) {
		this.nationalOccupationalStandards = nationalOccupationalStandards;
	}

}