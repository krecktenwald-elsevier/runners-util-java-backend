package com.krecktenwald.runnersutil.domain.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;


@Entity
@Table(name = "run")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Run {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateTime")
	private Date dateTime;

	@Column(name = "duration")
	private long duration;

	@Column(name = "distance")
	private Integer distance;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "route_id", referencedColumnName = "id")
	private Route route;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createDate", nullable = false)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updateDate")
	private Date updateDate;
}
