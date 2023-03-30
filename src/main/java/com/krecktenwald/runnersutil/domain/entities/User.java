package com.krecktenwald.runnersutil.domain.entities;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)

@Getter
@Setter
public class User extends AbstractCRUDEntity{
	@Id
	@GenericGenerator(name = "user_id", strategy = "uuid2")
	private String userId;
}
