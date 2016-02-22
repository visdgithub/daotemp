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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;

/**
 * ContentReviewer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "content_reviewer", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "email") )

public class ContentReviewer extends IstarUser  {
	private Set<TaskReviewer> taskReviewers = new HashSet<TaskReviewer>(0);
	private Set<Comment> comments = new HashSet<Comment>(0);

	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contentReviewer")

	public Set<TaskReviewer> getTaskReviewers() {
		return this.taskReviewers;
	}

	public void setTaskReviewers(Set<TaskReviewer> taskReviewers) {
		this.taskReviewers = taskReviewers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contentReviewer")

	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}