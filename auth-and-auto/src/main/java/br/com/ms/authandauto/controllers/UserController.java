package br.com.ms.authandauto.controllers;

import br.com.ms.authandauto.dtos.microservice.MicroserviceDTO;
import br.com.ms.authandauto.dtos.user.UserDTO;
import br.com.ms.authandauto.dtos.user.input.UserInDTO;
import br.com.ms.authandauto.dtos.user.output.UserCreatedOutDTO;
import br.com.ms.authandauto.dtos.user.output.UserWithMicroservisesAndRolesOutDTO;
import br.com.ms.authandauto.dtos.userToMicroservice.input.AuthInDTO;
import br.com.ms.authandauto.exceptions.user.UserAlreadyBoundedWithMicroserviceException;
import br.com.ms.authandauto.services.MicroserviceService;
import br.com.ms.authandauto.services.UserService;
import br.com.ms.authandauto.services.UserToMicroserviceService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
  @Autowired
  UserService userService;
  @Autowired
  MicroserviceService microserviceService;
  @Autowired
  UserToMicroserviceService userToMicroserviceService;
  @Autowired
  ModelMapper modelMapper;

  @PostMapping
  @ResponseBody
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<UserCreatedOutDTO> createUser(@Valid @RequestBody UserInDTO userIn) {
    return ResponseEntity.ok(userService.createUser(userIn));
  }

  @GetMapping
  public ResponseEntity<List<UserWithMicroservisesAndRolesOutDTO>>
  getAllUsersWithMicroservicesAndRoles() {
    return ResponseEntity
            .ok(userService.getAllUsersWithMicroservicesAndRoles());
  }

  @PutMapping("/{id-user}/microservice/{id-microservice}")
  public ResponseEntity<Void> bindUserToService
          (@PathVariable("id-user") Long idUser,
           @PathVariable("id-microservice") Long idMicroservice,
           @RequestBody AuthInDTO bindAuth) {
    if(userToMicroserviceService
           .existsUserBoundWithMicroservice(idUser,idMicroservice)){
      String message = new StringBuilder()
              .append("User id: ")
              .append(idUser)
              .append(" is already bounded with microservice id: ")
              .append(idMicroservice).toString();
      throw new UserAlreadyBoundedWithMicroserviceException(message);
    }
      UserDTO userDTO = userService.getUserById(idUser);
      MicroserviceDTO microserviceDTO = microserviceService
              .getMicroserviceById(idMicroservice);
      userToMicroserviceService.bindUserToMicroservice(
              userDTO,
              microserviceDTO,
              bindAuth
              );
      return ResponseEntity.ok().build();
  }
}