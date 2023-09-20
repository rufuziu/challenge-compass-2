package br.com.ms.b.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties({"id","password"})
public class UserDto {
  private Long id;
  private String name;
  private String email;
  private String password;
  private List<MicroserviceDto> microservices;
  public UserDto() {
    microservices = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public List<MicroserviceDto> getMicroservices() {
    return microservices;
  }

  public void setMicroservices(List<MicroserviceDto> microservices) {
    this.microservices = microservices;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
