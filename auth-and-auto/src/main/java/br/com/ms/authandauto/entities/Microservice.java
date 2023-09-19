package br.com.ms.authandauto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity(name="microservices")
public class Microservice {
  public Microservice(){}
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 16, nullable = false)
  private String name;
  @OneToMany(mappedBy = "microservice")
  @JsonIgnore
  private Set<UserToMicroservice> users;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<UserToMicroservice> getUsers() {
    return users;
  }

  public void setUsers(Set<UserToMicroservice> users) {
    this.users = users;
  }
}
