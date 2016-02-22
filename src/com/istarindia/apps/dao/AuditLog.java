package com.istarindia.apps.dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * AuditLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "audit_log", schema = "public")

public class AuditLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private String message;
	private Integer actorId;
	private Timestamp createdAt;

	// Constructors

	/** default constructor */
	public AuditLog() {
	}

	/** minimal constructor */
	public AuditLog(Integer actorId, Timestamp createdAt) {
		this.actorId = actorId;
		this.createdAt = createdAt;
	}

	/** full constructor */
	public AuditLog(String message, Integer actorId, Timestamp createdAt) {
		this.message = message;
		this.actorId = actorId;
		this.createdAt = createdAt;
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

	@Column(name = "message")

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "actor_id", nullable = false)

	public Integer getActorId() {
		return this.actorId;
	}

	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}

	@Column(name = "created_at", nullable = false, length = 29)

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

}