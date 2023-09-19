package br.com.ms.authandauto.dtos.input;

import br.com.ms.authandauto.entities.Microservice;
import br.com.ms.authandauto.entities.User;
import br.com.ms.authandauto.enums.ERole;

public class UserBindToMicroserviceInDTO {
  public UserBindToMicroserviceInDTO() {
  }

  private User user;
  private Microservice microservice;
  private ERole role;

  public UserBindToMicroserviceInDTO(User user,
                                     Microservice microservice,
                                     ERole role) {
    this.user = user;
    this.microservice = microservice;
    this.role = role;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Microservice getMicroservice() {
    return microservice;
  }

  public void setMicroservice(Microservice microservice) {
    this.microservice = microservice;
  }

  public ERole getRole() {
    return role;
  }

  public void setRole(ERole role) {
    this.role = role;
  }
}
