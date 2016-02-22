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
 * TaskReviewer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "task_reviewer", schema = "public")

public class TaskReviewer implements java.io.Serializable {

	// Fields

	private Integer id;
	private Task task;
	private ContentReviewer contentReviewer;
	private String status;

	// Constructors

	/** default constructor */
	public TaskReviewer() {
	}

	/** full constructor */
	public TaskReviewer(Task task, ContentReviewer contentReviewer, String status) {
		this.task = task;
		this.contentReviewer = contentReviewer;
		this.status = status;
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
	@JoinColumn(name = "task_id", nullable = false)

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reviewer_id", nullable = false)

	public ContentReviewer getContentReviewer() {
		return this.contentReviewer;
	}

	public void setContentReviewer(ContentReviewer contentReviewer) {
		this.contentReviewer = contentReviewer;
	}

	@Column(name = "status", nullable = false)

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}