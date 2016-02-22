package com.istarindia.apps.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;

/**
 * CreativeAdmin entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "creative_admin", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "email") )

public class CreativeAdmin extends IstarUser {

	

}