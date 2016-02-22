package com.istarindia.apps.dao;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Lesson entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "lesson", schema = "public")
@Inheritance(strategy = InheritanceType.JOINED)
public class Lesson implements java.io.Serializable {

	// Fields

	private Integer id;
	private Cmsession cmsession;
	private Integer duration;
	private String lessonType;
	private String tags;
	private String title;
	private String dtype;
	private Set<LearningObjective> learningObjectives = new HashSet<LearningObjective>(0);

	// Constructors

	/** default constructor */
	public Lesson() {
	}

	/** minimal constructor */
	public Lesson(Cmsession cmsession, String lessonType, String title, String dtype) {
		this.cmsession = cmsession;
		this.lessonType = lessonType;
		this.title = title;
		this.dtype = dtype;
	}

	/** full constructor */
	public Lesson(Cmsession cmsession, Integer duration, String lessonType, String tags, String title, String dtype,
			Set<LearningObjective> learningObjectives, Presentaion presentaion) {
		this.cmsession = cmsession;
		this.duration = duration;
		this.lessonType = lessonType;
		this.tags = tags;
		this.title = title;
		this.dtype = dtype;
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
	@JoinColumn(name = "session_id", nullable = false)

	public Cmsession getCmsession() {
		return this.cmsession;
	}

	public void setCmsession(Cmsession cmsession) {
		this.cmsession = cmsession;
	}

	@Column(name = "duration")

	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Column(name = "lesson_type", nullable = false)

	public String getLessonType() {
		return this.lessonType;
	}

	public void setLessonType(String lessonType) {
		this.lessonType = lessonType;
	}

	@Column(name = "tags")

	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Column(name = "title", nullable = false)

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "dtype", nullable = false, length = 31)

	public String getDtype() {
		return this.dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "learning_objective_lesson", schema = "public", joinColumns = {
			@JoinColumn(name = "lessonid", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "learning_objectiveid", nullable = false, updatable = false) })

	public Set<LearningObjective> getLearningObjectives() {
		return this.learningObjectives;
	}

	public void setLearningObjectives(Set<LearningObjective> learningObjectives) {
		this.learningObjectives = learningObjectives;
	}

	

}