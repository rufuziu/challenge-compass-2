package br.com.ms.f.controllers;

import br.com.ms.f.dtos.UserDto;
import br.com.ms.f.proxy.MsBProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/scholar")
public class ScholarController {
  @Autowired
  MsBProxy msBProxy;
  @GetMapping()
  public List<UserDto> getUsers()
  {
    return msBProxy.listAllUsers();
  }

  @GetMapping("/{id-user}/microsservice/{id-microservice}")
  public UserDto getUser(
          @PathVariable("id-user")Long userId,
          @PathVariable("id-microservice")Long microserviceId)
  {
    List<UserDto> users = msBProxy.listAllUsers();
    Optional<UserDto> userDto = users.stream().filter(u->u.getId()==userId).findFirst();

    return userDto.get();
  }
}
