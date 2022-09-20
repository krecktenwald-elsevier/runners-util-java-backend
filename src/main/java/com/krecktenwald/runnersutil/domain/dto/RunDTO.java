package com.krecktenwald.runnersutil.domain.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RunDTO {
	private long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
	private Date dateTime;

	private long duration;

	private Integer distance;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
	private Date createDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
	private Date updateDate;
}
