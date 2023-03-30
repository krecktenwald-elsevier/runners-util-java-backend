package com.krecktenwald.runnersutil.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "routes")
@EntityListeners(AuditingEntityListener.class)

@Getter
@Setter
public class Route extends AbstractCRUDEntity {
	@Id
	@GenericGenerator(name = "route_id", strategy = "uuid2")
	private String routeId;

	@Column(name = "name")
	private String name;

	@Column(name = "distance")
	private Integer distance;
}
