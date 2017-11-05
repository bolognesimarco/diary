package com.mb.skuldyree.spring.be.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("S")
public class Scholar extends User {

	@Transient
	public final String role = "scholar";
}
