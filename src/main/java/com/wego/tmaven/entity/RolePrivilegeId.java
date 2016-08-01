package com.wego.tmaven.entity;
// default package

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RolePrivilegeId entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Embeddable
public class RolePrivilegeId implements java.io.Serializable {

	// Fields

	private String rid;
	private String pid;

	// Constructors

	/** default constructor */
	public RolePrivilegeId() {
	}

	/** full constructor */
	public RolePrivilegeId(String rid, String pid) {
		this.rid = rid;
		this.pid = pid;
	}

	// Property accessors

	@Column(name = "rid", nullable = false, length = 32)
	public String getRid() {
		return this.rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	@Column(name = "pid", nullable = false, length = 32)
	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RolePrivilegeId))
			return false;
		RolePrivilegeId castOther = (RolePrivilegeId) other;

		return ((this.getRid() == castOther.getRid()) || (this.getRid() != null
				&& castOther.getRid() != null && this.getRid().equals(
				castOther.getRid())))
				&& ((this.getPid() == castOther.getPid()) || (this.getPid() != null
						&& castOther.getPid() != null && this.getPid().equals(
						castOther.getPid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRid() == null ? 0 : this.getRid().hashCode());
		result = 37 * result
				+ (getPid() == null ? 0 : this.getPid().hashCode());
		return result;
	}

}