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
 * Task entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "task", schema = "public")

public class Task implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer itemId;
	private String itemType;
	private String reviewScheme;
	private String status;
	private String taskName;
	private Integer actorId;
	private Integer ownerId;
	private Set<TaskReviewer> taskReviewers = new HashSet<TaskReviewer>(0);

	// Constructors

	/** default constructor */
	public Task() {
	}

	/** minimal constructor */
	public Task(Integer itemId, String itemType, String status, String taskName, Integer actorId, Integer ownerId) {
		this.itemId = itemId;
		this.itemType = itemType;
		this.status = status;
		this.taskName = taskName;
		this.actorId = actorId;
		this.ownerId = ownerId;
	}

	/** full constructor */
	public Task(Integer itemId, String itemType, String reviewScheme, String status, String taskName, Integer actorId,
			Integer ownerId, Set<TaskReviewer> taskReviewers) {
		this.itemId = itemId;
		this.itemType = itemType;
		this.reviewScheme = reviewScheme;
		this.status = status;
		this.taskName = taskName;
		this.actorId = actorId;
		this.ownerId = ownerId;
		this.taskReviewers = taskReviewers;
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

	@Column(name = "item_id", nullable = false)

	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	@Column(name = "item_type", nullable = false)

	public String getItemType() {
		return this.itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	@Column(name = "review_scheme")

	public String getReviewScheme() {
		return this.reviewScheme;
	}

	public void setReviewScheme(String reviewScheme) {
		this.reviewScheme = reviewScheme;
	}

	@Column(name = "status", nullable = false)

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "task_name", nullable = false)

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	@Column(name = "actor_id", nullable = false)

	public Integer getActorId() {
		return this.actorId;
	}

	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}

	@Column(name = "owner_id", nullable = false)

	public Integer getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "task")

	public Set<TaskReviewer> getTaskReviewers() {
		return this.taskReviewers;
	}

	public void setTaskReviewers(Set<TaskReviewer> taskReviewers) {
		this.taskReviewers = taskReviewers;
	}

}