package com.krecktenwald.runnersutil.domain.dto.mapper.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.krecktenwald.runnersutil.domain.dto.AbstractCRUDEntityDTO;
import com.krecktenwald.runnersutil.domain.dto.mapper.CRUDEntityVisitor;
import com.krecktenwald.runnersutil.domain.entities.AbstractCRUDEntity;
import com.krecktenwald.runnersutil.domain.entities.Route;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RunDTO extends AbstractCRUDEntityDTO {
	private String runId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date_time")
	private Date startDateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date_time")
	private Date endDateTime;

	private Integer distance;

	private Route route;

	@Override
	public <T extends AbstractCRUDEntity> T accept(CRUDEntityVisitor<T> crudEntityDTOVisitor) {
		return crudEntityDTOVisitor.visit(this);
	}
}
