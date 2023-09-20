package br.com.ms.f.dtos;

import java.util.ArrayList;
import java.util.List;

public class MicroserviceDTO {
  private Long id;
  private String name;
  private List<UserWithRoleDTO> users;

  public MicroserviceDTO() {
    users = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<UserWithRoleDTO> getUsers() {
    return users;
  }

  public void setUsers(List<UserWithRoleDTO> users) {
    this.users = users;
  }
}