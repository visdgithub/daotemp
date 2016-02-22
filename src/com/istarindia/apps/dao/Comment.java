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
 * Comment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "comment", schema = "public")

public class Comment implements java.io.Serializable {

	// Fields

	private Integer id;
	private Slide slide;
	private ContentReviewer contentReviewer;
	private String comment;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** minimal constructor */
	public Comment(Slide slide, ContentReviewer contentReviewer) {
		this.slide = slide;
		this.contentReviewer = contentReviewer;
	}

	/** full constructor */
	public Comment(Slide slide, ContentReviewer contentReviewer, String comment) {
		this.slide = slide;
		this.contentReviewer = contentReviewer;
		this.comment = comment;
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
	@JoinColumn(name = "slide_id", nullable = false)

	public Slide getSlide() {
		return this.slide;
	}

	public void setSlide(Slide slide) {
		this.slide = slide;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reviewer_id", nullable = false)

	public ContentReviewer getContentReviewer() {
		return this.contentReviewer;
	}

	public void setContentReviewer(ContentReviewer contentReviewer) {
		this.contentReviewer = contentReviewer;
	}

	@Column(name = "comment")

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}