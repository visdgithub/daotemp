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
 * Slide entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "slide", schema = "public")

public class Slide implements java.io.Serializable {

	// Fields

	private Integer id;
	private Presentaion presentaion;
	private String slideText;
	private String teacherNotes;
	private String studentNotes;
	private Set<Comment> comments = new HashSet<Comment>(0);

	// Constructors

	/** default constructor */
	public Slide() {
	}

	/** minimal constructor */
	public Slide(Presentaion presentaion) {
		this.presentaion = presentaion;
	}

	/** full constructor */
	public Slide(Presentaion presentaion, String slideText, String teacherNotes, String studentNotes,
			Set<Comment> comments) {
		this.presentaion = presentaion;
		this.slideText = slideText;
		this.teacherNotes = teacherNotes;
		this.studentNotes = studentNotes;
		this.comments = comments;
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
	@JoinColumn(name = "presentation_id", nullable = false)

	public Presentaion getPresentaion() {
		return this.presentaion;
	}

	public void setPresentaion(Presentaion presentaion) {
		this.presentaion = presentaion;
	}

	@Column(name = "slide_text")

	public String getSlideText() {
		return this.slideText;
	}

	public void setSlideText(String slideText) {
		this.slideText = slideText;
	}

	@Column(name = "teacher_notes")

	public String getTeacherNotes() {
		return this.teacherNotes;
	}

	public void setTeacherNotes(String teacherNotes) {
		this.teacherNotes = teacherNotes;
	}

	@Column(name = "student_notes")

	public String getStudentNotes() {
		return this.studentNotes;
	}

	public void setStudentNotes(String studentNotes) {
		this.studentNotes = studentNotes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "slide")

	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}