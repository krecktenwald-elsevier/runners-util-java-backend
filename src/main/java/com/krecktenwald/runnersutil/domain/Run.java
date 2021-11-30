package com.krecktenwald.runnersutil.domain;

import java.util.Date;
import java.util.concurrent.TimeUnit;

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

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "run")
@EntityListeners(AuditingEntityListener.class)
public class Run {

	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd");
	private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormat.forPattern("HH:mm");

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateTime", nullable = true)
	private Date dateTime;

	@JsonProperty
	private String localDate;

	@JsonProperty
	private String localTime;

	@Column(name = "duration", nullable = true)
	private long duration;

	@JsonProperty
	private String durationFormatted;

	@Column(name = "distance", nullable = true)
	public Double getDistance() {
		return distance;
	}

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

	public String getLocalDate() {
		DateTime dt = new DateTime(getDateTime());
		return DATE_FORMATTER.print(dt);
	}

	public void setLocalDate(String localDate) {
		this.localDate = localDate;
	}

	public String getLocalTime() {
		DateTime dt = new DateTime(getDateTime());
		return TIME_FORMATTER.print(dt);
	}

	public void setLocalTime(String localTime) {
		this.localTime = localTime;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getDurationFormatted() {
		long milliseconds = getDuration();
		long hours = TimeUnit.MILLISECONDS.toHours(milliseconds);
		milliseconds -= TimeUnit.HOURS.toMillis(hours);
		long minutes = TimeUnit.MILLISECONDS.toMinutes(milliseconds);
		milliseconds -= TimeUnit.MINUTES.toMillis(minutes);
		long seconds = TimeUnit.MILLISECONDS.toSeconds(milliseconds);

		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}

	public void setDurationFormatted(String durationFormatted) {
		this.durationFormatted = durationFormatted;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	@Column(name = "distance", nullable = true)
	private Double distance;
}
