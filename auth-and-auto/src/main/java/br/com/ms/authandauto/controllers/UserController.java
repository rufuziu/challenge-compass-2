package br.com.ms.authandauto.controllers;

import br.com.ms.authandauto.dtos.input.user.UserInDTO;
import br.com.ms.authandauto.dtos.output.user.UserCreatedOutDTO;
import br.com.ms.authandauto.dtos.output.user.UserOutDTO;
import br.com.ms.authandauto.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
  @Autowired
  UserService userService;
  @PostMapping
  public ResponseEntity<UserCreatedOutDTO> createUser(@Valid @RequestBody UserInDTO userIn) {
    return ResponseEntity.ok(userService.createUser(userIn));
  }
  @GetMapping
  public ResponseEntity<List<UserOutDTO>> getAllUsers(){
//  public ResponseEntity<List<User>> getAllUsers(){
    return ResponseEntity.ok(userService.getAllUsers());
  }
}
