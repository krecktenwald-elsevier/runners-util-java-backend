package com.krecktenwald.runnersutil.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "run")
@EntityListeners(AuditingEntityListener.class)
public class Run {

	private static final DateTimeFormatter SELECTED_DATE_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd");
	private static final DateTimeFormatter SELECTED_TIME_FORMATTER = DateTimeFormat.forPattern("HH:mm");

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateTime", nullable = true)
	private Date dateTime;

	@Column(name = "duration", nullable = true)
	private long duration;

	@JsonProperty
	private String localDateSelection;

	@JsonProperty
	private String localTimeSelection;

	public Run() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getLocalDateSelection() {
		DateTime dt = new DateTime(getDateTime());
		return SELECTED_DATE_FORMATTER.print(dt);

	}

	public void setLocalDateSelection(String localDateSelection) {
		this.localDateSelection = localDateSelection;
	}

	public String getLocalTimeSelection() {
		DateTime dt = new DateTime(getDateTime());
		return SELECTED_TIME_FORMATTER.print(dt);
	}

	public void setLocalTimeSelection(String localTimeSelection) {
		this.localTimeSelection = localTimeSelection;
	}
}
