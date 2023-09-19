package br.com.ms.authandauto.dtos.output;

public class UserBindToMicroserviceOutDTO {
  public UserBindToMicroserviceOutDTO() {}
  private String emailUser;
  private String nameMicroservice;

  public UserBindToMicroserviceOutDTO(String emailUser, String nameMicroservice) {
    this.emailUser = emailUser;
    this.nameMicroservice = nameMicroservice;
  }

  public String getEmailUser() {
    return emailUser;
  }

  public void setEmailUser(String emailUser) {
    this.emailUser = emailUser;
  }

  public String getNameMicroservice() {
    return nameMicroservice;
  }

  public void setNameMicroservice(String nameMicroservice) {
    this.nameMicroservice = nameMicroservice;
  }
}
