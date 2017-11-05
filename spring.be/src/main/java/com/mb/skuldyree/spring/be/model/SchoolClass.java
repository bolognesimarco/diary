package com.mb.skuldyree.spring.be.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class SchoolClass {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String name;
	

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="CLASS_ID")
	private Set<Subject> subjects;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
}
