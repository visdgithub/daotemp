package com.istarindia.apps.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * LearningOutcome entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "learning_outcome", schema = "public")

public class LearningOutcome implements java.io.Serializable {

	// Fields

	private Integer id;
	private QualificationPack qualificationPack;
	private String title;

	// Constructors

	/** default constructor */
	public LearningOutcome() {
	}

	/** full constructor */
	public LearningOutcome(QualificationPack qualificationPack, String title) {
		this.qualificationPack = qualificationPack;
		this.title = title;
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

	@Column(name = "title", nullable = false)

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}