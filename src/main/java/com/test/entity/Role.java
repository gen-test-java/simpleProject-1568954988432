package com.test.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import java.lang.Long;
import javax.persistence.Id;
import java.lang.String;

@Entity
public class Role implements Serializable {

	@Id
	private long id;
	private String name;

	public long getId() {
		return this.id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}
}