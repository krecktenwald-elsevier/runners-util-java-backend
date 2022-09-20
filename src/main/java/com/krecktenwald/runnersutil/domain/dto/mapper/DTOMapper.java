package com.krecktenwald.runnersutil.domain.dto.mapper;

import org.mapstruct.Mapper;

import com.krecktenwald.runnersutil.domain.dto.RouteDTO;
import com.krecktenwald.runnersutil.domain.dto.RunDTO;
import com.krecktenwald.runnersutil.domain.entities.Route;
import com.krecktenwald.runnersutil.domain.entities.Run;

/**
 * * A MapStruct (mapstruct.org) based mapping interface for converting
 * POJO/Entity objects to Data Transfer Objects (DTOs), and vice-versa
 */
@Mapper(componentModel = "spring")
public abstract class DTOMapper {

	public abstract Route routeDTOToRoute(RouteDTO value);

	public abstract Run runDTOToRun(RunDTO value);
}
