package com.krecktenwald.runnersutil.domain.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class RouteDTO {

	private long id;

	private String name;

	private double mileage;
}
