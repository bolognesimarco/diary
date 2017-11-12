package com.mb.skuldyree.spring.be.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("H")
public class Headmaster extends User {
	
//	@OneToMany(mappedBy="headmaster", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@OneToMany(orphanRemoval=true, fetch=FetchType.EAGER)
    @JoinColumn(name="HEADMASTER_ID") // join column is in table for Order
	private Set<SchoolClass> classes = new HashSet<>();
	

	public Set<SchoolClass> getClasses() {
		return classes;
	}

	public void setClasses(Set<SchoolClass> classes) {
		this.classes = classes;
	}
	
	
}
