package com.mb.skuldyree.spring.be.model;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class WeekDaySchedule implements Comparable<WeekDaySchedule> {

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private WeekDayEnum weekDay;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="weekDaySchedule")
	@OrderBy("dayHour")
	private SortedSet<DayHourSchedule> dayHourSchedules = new TreeSet<>();
	
	@ManyToOne
	@JoinColumn(name="SCHEDULE_ID", nullable=false)
	private Schedule schedule;

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

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@Override
	public int compareTo(WeekDaySchedule o) {
		return this.weekDay.compareTo(o.weekDay);
	}
	
	
}
