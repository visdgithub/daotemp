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
 * Cmsession entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cmsession", schema = "public")

public class Cmsession implements java.io.Serializable {

	// Fields

	private Integer id;
	private Module module;
	private ContentAdmin contentAdmin;
	private String title;
	private Set<Lesson> lessons = new HashSet<Lesson>(0);

	// Constructors

	/** default constructor */
	public Cmsession() {
	}

	/** minimal constructor */
	public Cmsession(Module module, ContentAdmin contentAdmin, String title) {
		this.module = module;
		this.contentAdmin = contentAdmin;
		this.title = title;
	}

	/** full constructor */
	public Cmsession(Module module, ContentAdmin contentAdmin, String title, Set<Lesson> lessons) {
		this.module = module;
		this.contentAdmin = contentAdmin;
		this.title = title;
		this.lessons = lessons;
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
	@JoinColumn(name = "module_id", nullable = false)

	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uploader_admin_id", nullable = false)

	public ContentAdmin getContentAdmin() {
		return this.contentAdmin;
	}

	public void setContentAdmin(ContentAdmin contentAdmin) {
		this.contentAdmin = contentAdmin;
	}

	@Column(name = "title", nullable = false)

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cmsession")

	public Set<Lesson> getLessons() {
		return this.lessons;
	}

	public void setLessons(Set<Lesson> lessons) {
		this.lessons = lessons;
	}

}