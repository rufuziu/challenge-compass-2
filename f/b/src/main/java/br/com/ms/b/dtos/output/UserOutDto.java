package br.com.ms.b.dtos.output;

public class UserOutDto {
   public UserOutDto(){}
  private String name;
  private String role;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }
}
