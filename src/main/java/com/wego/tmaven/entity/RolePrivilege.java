package com.wego.tmaven.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RolePrivilege entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "role_privilege", catalog = "testmaven")
public class RolePrivilege implements java.io.Serializable {

	// Fields

	private RolePrivilegeId id;
	private Role role;
	private Privilege privilege;

	// Constructors

	/** default constructor */
	public RolePrivilege() {
	}

	/** full constructor */
	public RolePrivilege(RolePrivilegeId id, Role role, Privilege privilege) {
		this.id = id;
		this.role = role;
		this.privilege = privilege;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "rid", column = @Column(name = "rid", nullable = false, length = 32)),
			@AttributeOverride(name = "pid", column = @Column(name = "pid", nullable = false, length = 32)) })
	public RolePrivilegeId getId() {
		return this.id;
	}

	public void setId(RolePrivilegeId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rid", nullable = false, insertable = false, updatable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pid", nullable = false, insertable = false, updatable = false)
	public Privilege getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

}