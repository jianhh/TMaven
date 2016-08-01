package com.wego.tmaven.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Privilege entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "privilege", catalog = "testmaven")
public class Privilege implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String url;
	private Set<RolePrivilege> rolePrivileges = new HashSet<RolePrivilege>(0);

	// Constructors

	/** default constructor */
	public Privilege() {
	}

	/** minimal constructor */
	public Privilege(String id, String name, String url) {
		this.id = id;
		this.name = name;
		this.url = url;
	}

	/** full constructor */
	public Privilege(String id, String name, String url,
			Set<RolePrivilege> rolePrivileges) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.rolePrivileges = rolePrivileges;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 32)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "url", nullable = false, length = 100)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "privilege")
	public Set<RolePrivilege> getRolePrivileges() {
		return this.rolePrivileges;
	}

	public void setRolePrivileges(Set<RolePrivilege> rolePrivileges) {
		this.rolePrivileges = rolePrivileges;
	}

}