package br.com.ms.authandauto.entities;

import jakarta.persistence.*;

@Entity(name="microservices")
public class Microservice {
  public Microservice(){}
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 16, nullable = false)
  private String name;

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
}
