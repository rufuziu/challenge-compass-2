package br.com.ms.authandauto.dtos.output.microservice;

import br.com.ms.authandauto.enums.ERole;

public class MicroserviceOutDTO {
  public MicroserviceOutDTO() {
  }
  private String name;
  private ERole roleUser;

  public String getName() {
    return name;
  }

  public ERole getRoleUser() {
    return roleUser;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setRoleUser(ERole roleUser) {
    this.roleUser = roleUser;
  }

  public MicroserviceOutDTO(String name,
                            ERole roleUser) {
    this.name = name;
    this.roleUser = roleUser;
  }
}
