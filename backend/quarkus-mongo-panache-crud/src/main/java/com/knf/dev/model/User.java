package com.knf.dev.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

@Data
@RegisterForReflection
@Entity
@Table(name = "users")
public class User  {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String emailId;
	
	
}