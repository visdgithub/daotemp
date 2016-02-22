package com.istarindia.apps.dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * TaskLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "task_log", schema = "public")

public class TaskLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer taskId;
	private String changedStatus;
	private String comments;
	private Timestamp createdAt;
	private Integer actorId;

	// Constructors

	/** default constructor */
	public TaskLog() {
	}

	/** minimal constructor */
	public TaskLog(Integer taskId, String changedStatus, Timestamp createdAt) {
		this.taskId = taskId;
		this.changedStatus = changedStatus;
		this.createdAt = createdAt;
	}

	/** full constructor */
	public TaskLog(Integer taskId, String changedStatus, String comments, Timestamp createdAt, Integer actorId) {
		this.taskId = taskId;
		this.changedStatus = changedStatus;
		this.comments = comments;
		this.createdAt = createdAt;
		this.actorId = actorId;
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

	@Column(name = "task_id", nullable = false)

	public Integer getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	@Column(name = "changed_status", nullable = false)

	public String getChangedStatus() {
		return this.changedStatus;
	}

	public void setChangedStatus(String changedStatus) {
		this.changedStatus = changedStatus;
	}

	@Column(name = "comments")

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(name = "created_at", nullable = false, length = 29)

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "actor_id")

	public Integer getActorId() {
		return this.actorId;
	}

	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}

}