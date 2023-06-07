package com.bunnyshell.hackathon.model;


import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.*;
import lombok.Data;

@Data
@RegisterForReflection
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;
  private String firstName;
  private String lastName;
  private String emailId;
}