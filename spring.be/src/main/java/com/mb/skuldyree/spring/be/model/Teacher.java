package com.mb.skuldyree.spring.be.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("T")
public class Teacher extends User {

	@Transient
	public final String role = "teacher";
}
