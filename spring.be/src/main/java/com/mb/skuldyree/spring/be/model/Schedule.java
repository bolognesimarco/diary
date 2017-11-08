package com.mb.skuldyree.spring.be.model;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

@Entity
public class Schedule {

	@Id
	@GeneratedValue
	private long id;
	
	@OneToOne
	private SchoolClass schoolClass;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="schedule")
	@OrderBy("weekDay")
	private SortedSet<WeekDaySchedule> weekDaySchedules = new TreeSet<>();

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

	public SchoolClass getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(SchoolClass schoolClass) {
		this.schoolClass = schoolClass;
	}

	
	
}
