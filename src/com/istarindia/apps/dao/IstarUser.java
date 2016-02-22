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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;

/**
 * IstarUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "istar_user", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "email") )
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class IstarUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String email;
	private String gender;
	private Boolean isVerified;
	private String istarAuthorizationToken;
	private Long mobile;
	private String name;
	private String password;
	private Boolean tokenExpired;
	private String tokenVerified;
	private String userType;
	private Organization organization;
	
	// Constructors

	/** default constructor */
	public IstarUser() {
	}

	/** minimal constructor */
	public IstarUser(String email, String name, String password, String userType) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.userType = userType;
	}

	/** full constructor */
	public IstarUser(String email, String gender, Boolean isVerified, String istarAuthorizationToken, Long mobile,
			String name, String password, Boolean tokenExpired, String tokenVerified, String userType,
			ContentCreator contentCreator, Student student, CreativeCreator creativeCreator,
			ContentReviewer contentReviewer, CreativeAdmin creativeAdmin, Set<Task> tasksForActorId,
			ContentAdmin contentAdmin, Set<Task> tasksForOwnerId, SuperAdmin superAdmin) {
		this.email = email;
		this.gender = gender;
		this.isVerified = isVerified;
		this.istarAuthorizationToken = istarAuthorizationToken;
		this.mobile = mobile;
		this.name = name;
		this.password = password;
		this.tokenExpired = tokenExpired;
		this.tokenVerified = tokenVerified;
		this.userType = userType;
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

	@Column(name = "email", unique = true, nullable = false)

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "gender")

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "is_verified")

	public Boolean getIsVerified() {
		return this.isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	@Column(name = "istar_authorization_token")

	public String getIstarAuthorizationToken() {
		return this.istarAuthorizationToken;
	}

	public void setIstarAuthorizationToken(String istarAuthorizationToken) {
		this.istarAuthorizationToken = istarAuthorizationToken;
	}

	@Column(name = "mobile")

	public Long getMobile() {
		return this.mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	@Column(name = "name", nullable = false)

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", nullable = false)

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "token_expired")

	public Boolean getTokenExpired() {
		return this.tokenExpired;
	}

	public void setTokenExpired(Boolean tokenExpired) {
		this.tokenExpired = tokenExpired;
	}

	@Column(name = "token_verified")

	public String getTokenVerified() {
		return this.tokenVerified;
	}

	public void setTokenVerified(String tokenVerified) {
		this.tokenVerified = tokenVerified;
	}

	@Column(name = "user_type", nullable = false)

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	

	




}