package br.com.ms.f.dtos;

import br.com.ms.f.enums.RoleEnum;

public class MicroserviceDto {
  private String name;
  private RoleEnum roleUser;

  public MicroserviceDto() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RoleEnum getRoleUser() {
    return roleUser;
  }

  public void setRoleUser(RoleEnum roleUser) {
    this.roleUser = roleUser;
  }
}