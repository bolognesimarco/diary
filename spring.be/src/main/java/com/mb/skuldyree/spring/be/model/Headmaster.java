package com.mb.skuldyree.spring.be.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("H")
public class Headmaster extends User {
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="HEADMASTER_ID")
	private Set<SchoolClass> classes;
	
	@Transient
	public final String role = "headmaster";

	public Set<SchoolClass> getClasses() {
		return classes;
	}

	public void setClasses(Set<SchoolClass> classes) {
		this.classes = classes;
	}
	
	
}
