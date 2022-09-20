package com.krecktenwald.runnersutil.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "route")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name", nullable = true)
	private String name;

	@Column(name = "approxMileage", nullable = true)
	private double approxMileage;

	@OneToOne(mappedBy = "route")
	private Run run;
}
