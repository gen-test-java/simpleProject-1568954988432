package com.test.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import java.lang.Long;
import javax.persistence.Id;
import java.lang.String;
import com.test.entity.Role;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class User implements Serializable {

	@Id
	private Long id;
	private String userName;
	private String password;
	@OneToMany(mappedBy = "User", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Roles> roles;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public List<Roles> getRoles() {
		return this.roles;
	}

	public void setRoles(final List<Roles> roles) {
		this.roles = roles;
	}
}