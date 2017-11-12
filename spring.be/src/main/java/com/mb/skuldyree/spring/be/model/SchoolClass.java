package com.mb.skuldyree.spring.be.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class SchoolClass {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String name;
	
//	@ManyToOne
//	@Fetch(FetchMode.SELECT)
//	private Headmaster headmaster;
	

//	@OneToMany(mappedBy="schoolClass", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@OneToMany(orphanRemoval=true, fetch=FetchType.EAGER)
    @JoinColumn(name="SCHOOL_CLASS_ID")
	private Set<Subject> subjects = new HashSet<>();
	
//	@OneToOne(mappedBy="schoolClass", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@OneToOne(orphanRemoval=true, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="SCHEDULE_ID")
	private Schedule schedule;

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

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

//	public Headmaster getHeadmaster() {
//		return headmaster;
//	}
//
//	public void setHeadmaster(Headmaster headmaster) {
//		this.headmaster = headmaster;
//	}
	
	
}
