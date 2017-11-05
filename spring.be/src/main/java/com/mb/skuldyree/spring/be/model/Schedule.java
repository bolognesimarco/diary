package com.mb.skuldyree.spring.be.model;

import java.util.SortedSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Schedule {

	@Id
	@GeneratedValue
	private long id;
	
	@OneToMany
	@OrderBy("weekDay")
	private SortedSet<WeekDaySchedule> weekDaySchedules;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public SortedSet<WeekDaySchedule> getWeekDaySchedules() {
		return weekDaySchedules;
	}

	public void setWeekDaySchedules(SortedSet<WeekDaySchedule> weekDaySchedules) {
		this.weekDaySchedules = weekDaySchedules;
	}

	
	
}
