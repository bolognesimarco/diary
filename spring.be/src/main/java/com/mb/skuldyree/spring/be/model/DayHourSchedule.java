package com.mb.skuldyree.spring.be.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DayHourSchedule implements Comparable<DayHourSchedule>{

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="hour_of_day")
	private DayHourEnum dayHour;
	
	@ManyToOne
	@JoinColumn(name="WEEKDAY_SCHEDULE_ID", nullable=false)
	private WeekDaySchedule weekDaySchedule;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SUBJECT_ID")
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

	public WeekDaySchedule getWeekDaySchedule() {
		return weekDaySchedule;
	}

	public void setWeekDaySchedule(WeekDaySchedule weekDaySchedule) {
		this.weekDaySchedule = weekDaySchedule;
	}

	@Override
	public int compareTo(DayHourSchedule o) {
		return this.dayHour.compareTo(o.dayHour);
	}

	
}
