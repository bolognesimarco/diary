package com.mb.skuldyree.spring.be.model;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

@Entity
public class Schedule {

	@Id
	@GeneratedValue
	private long id;
	
	
//	@OneToMany(cascade=CascadeType.ALL, mappedBy="schedule")
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
    @JoinColumn(name="SCHEDULE_ID")
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

	
	
}
