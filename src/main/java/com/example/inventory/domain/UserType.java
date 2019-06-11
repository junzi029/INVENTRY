package com.example.inventory.domain;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

public class UserType {

	private Integer id;
	@NotBlank
	private String typeName;
	private Date registered;
	private Date updated;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Date getRegistered() {
		return this.registered;
	}

	public void setRegistered(Date registered) {
		this.registered = registered;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}
