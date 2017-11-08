package com.mb.skuldyree.spring.be.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("H")
public class Headmaster extends User {
	
	@OneToMany(mappedBy="headmaster", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<SchoolClass> classes = new HashSet<>();
	
	@Transient
	public final String role = "headmaster";

	public Set<SchoolClass> getClasses() {
		return classes;
	}

	public void setClasses(Set<SchoolClass> classes) {
		this.classes = classes;
	}
	
	
}
