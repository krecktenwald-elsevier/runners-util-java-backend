package com.krecktenwald.runnersutil.domain.dto;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.krecktenwald.runnersutil.domain.dto.RouteDTO;
import com.krecktenwald.runnersutil.domain.entities.Route;
import com.krecktenwald.runnersutil.domain.entities.Run;

import lombok.Data;

@Data
public class UserDTO {
	private String userId;

	private String email;

	private String firstName;

	private String lastName;

	private String password;

	private Set<RouteDTO> routes;

	private Set<RunDTO> runs;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
	private Date createDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
	private Date updateDate;
}
