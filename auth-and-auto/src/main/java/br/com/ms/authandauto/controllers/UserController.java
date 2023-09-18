package br.com.ms.authandauto.controllers;

import br.com.ms.authandauto.dtos.input.UserInDTO;
import br.com.ms.authandauto.dtos.output.UserOutDTO;
import br.com.ms.authandauto.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
  @Autowired
  UserService userService;

  @PostMapping
  public ResponseEntity<UserOutDTO> createUser(@Valid @RequestBody UserInDTO userIn) {
    return ResponseEntity.ok(userService.createUser(userIn));
  }
}
