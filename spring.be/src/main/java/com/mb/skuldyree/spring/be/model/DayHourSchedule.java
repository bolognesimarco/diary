package com.mb.skuldyree.spring.be.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DayHourSchedule {

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private DayHourEnum dayHour;
	
	@ManyToOne
	private Subject subject;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public DayHourEnum getDayHour() {
		return dayHour;
	}

	public void setDayHour(DayHourEnum dayHour) {
		this.dayHour = dayHour;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	
}
