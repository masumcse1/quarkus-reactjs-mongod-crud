package com.knf.dev.model;


import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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