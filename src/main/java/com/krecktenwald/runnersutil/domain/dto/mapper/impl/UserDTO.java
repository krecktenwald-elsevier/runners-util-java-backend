package com.krecktenwald.runnersutil.domain.dto.mapper.impl;

import java.util.Set;

import com.krecktenwald.runnersutil.domain.dto.AbstractCRUDEntityDTO;
import com.krecktenwald.runnersutil.domain.dto.mapper.CRUDEntityVisitor;
import com.krecktenwald.runnersutil.domain.entities.AbstractCRUDEntity;

import lombok.Data;

@Data
public class UserDTO extends AbstractCRUDEntityDTO {
	private String userId;

	private Set<RouteDTO> routes;

	private Set<RunDTO> runs;

	@Override
	public <T extends AbstractCRUDEntity> T accept(CRUDEntityVisitor<T> crudEntityDTOVisitor) {
		return crudEntityDTOVisitor.visit(this);
	}
}
