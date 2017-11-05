package com.mb.skuldyree.spring.be.model;

import java.util.SortedSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class WeekDaySchedule {

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private WeekDayEnum weekDay;
	
	@OneToMany
	@OrderBy("dayHour")
	private SortedSet<DayHourSchedule> dayHourSchedules;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public WeekDayEnum getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(WeekDayEnum weekDay) {
		this.weekDay = weekDay;
	}

	public SortedSet<DayHourSchedule> getDayHourSchedules() {
		return dayHourSchedules;
	}

	public void setDayHourSchedules(SortedSet<DayHourSchedule> dayHourSchedules) {
		this.dayHourSchedules = dayHourSchedules;
	}
	
	
	
	
}
