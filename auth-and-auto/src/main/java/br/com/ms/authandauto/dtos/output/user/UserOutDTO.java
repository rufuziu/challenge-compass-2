package br.com.ms.authandauto.dtos.output.user;

import br.com.ms.authandauto.dtos.output.microservice.MicroserviceOutDTO;

import java.util.ArrayList;
import java.util.List;

public class UserOutDTO {
  public UserOutDTO() {
    microservices = new ArrayList<>();
  }
  private String name;
  private String email;
  private List<MicroserviceOutDTO> microservices;
  public String getName() {
    return name;
  }
  public String getEmail() {
    return email;
  }
  public List<MicroserviceOutDTO> getMicroservices() {
    return microservices;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setMicroservices(List<MicroserviceOutDTO> microservices) {
    this.microservices = microservices;
  }

  public UserOutDTO(String name, String email) {
    this.name = name;
    this.email = email;
    microservices = new ArrayList<>();
  }
}
