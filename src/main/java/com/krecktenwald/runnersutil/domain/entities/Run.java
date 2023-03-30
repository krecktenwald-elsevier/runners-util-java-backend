package com.krecktenwald.runnersutil.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "runs")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Run extends AbstractCRUDEntity {
	@Id
	@GenericGenerator(name = "run_id", strategy = "uuid2")
	private String runId;

	@Column(name = "distance")
	private Integer distance;

	@OneToOne
	@JoinColumn(name = "route_id")
	private Route route;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date_time")
	private Date startDateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date_time")
	private Date endDateTime;
}
