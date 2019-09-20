package com.test.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import java.lang.Long;
import javax.persistence.Id;
import java.lang.String;
import com.test.entity.Student;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Department implements Serializable {

	@Id
	private long id;
	private String departmentName;
	@OneToMany(mappedBy = "Department", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Student> studentList;

	public long getId() {
		return this.id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(final String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Student> getStudentList() {
		return this.studentList;
	}

	public void setStudentList(final List<Student> studentList) {
		this.studentList = studentList;
	}
}