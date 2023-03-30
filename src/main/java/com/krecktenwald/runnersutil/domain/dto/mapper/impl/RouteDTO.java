package com.krecktenwald.runnersutil.domain.dto.mapper.impl;

import com.krecktenwald.runnersutil.domain.dto.AbstractCRUDEntityDTO;
import com.krecktenwald.runnersutil.domain.dto.mapper.CRUDEntityVisitor;
import com.krecktenwald.runnersutil.domain.entities.AbstractCRUDEntity;

import lombok.Data;

@Data
public class RouteDTO extends AbstractCRUDEntityDTO {
	private String routeId;

	private String name;

	private Integer distance;

	@Override
	public <T extends AbstractCRUDEntity> T accept(CRUDEntityVisitor<T> crudEntityDTOVisitor) {
		return crudEntityDTOVisitor.visit(this);
	}
}
