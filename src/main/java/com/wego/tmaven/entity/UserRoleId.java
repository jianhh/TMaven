package com.wego.tmaven.entity;
// default package

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserRoleId entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Embeddable
public class UserRoleId implements java.io.Serializable {

	// Fields

	private String uid;
	private String rid;

	// Constructors

	/** default constructor */
	public UserRoleId() {
	}

	/** full constructor */
	public UserRoleId(String uid, String rid) {
		this.uid = uid;
		this.rid = rid;
	}

	// Property accessors

	@Column(name = "uid", nullable = false, length = 32)
	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "rid", nullable = false, length = 32)
	public String getRid() {
		return this.rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserRoleId))
			return false;
		UserRoleId castOther = (UserRoleId) other;

		return ((this.getUid() == castOther.getUid()) || (this.getUid() != null
				&& castOther.getUid() != null && this.getUid().equals(
				castOther.getUid())))
				&& ((this.getRid() == castOther.getRid()) || (this.getRid() != null
						&& castOther.getRid() != null && this.getRid().equals(
						castOther.getRid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUid() == null ? 0 : this.getUid().hashCode());
		result = 37 * result
				+ (getRid() == null ? 0 : this.getRid().hashCode());
		return result;
	}

}