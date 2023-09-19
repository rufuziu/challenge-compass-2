package br.com.ms.authandauto.services;

import br.com.ms.authandauto.dtos.microservice.MicroserviceDTO;
import br.com.ms.authandauto.dtos.user.UserDTO;
import br.com.ms.authandauto.dtos.userToMicroservice.input.AuthInDTO;
import br.com.ms.authandauto.entities.Microservice;
import br.com.ms.authandauto.entities.User;
import br.com.ms.authandauto.entities.UserToMicroservice;
import br.com.ms.authandauto.enums.ERole;
import br.com.ms.authandauto.exceptions.microservice.MicroserviceNotFoundException;
import br.com.ms.authandauto.exceptions.user.UserNotFoundException;
import br.com.ms.authandauto.repositories.UserToMicroserviceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserToMicroserviceService {
  @Autowired
  UserToMicroserviceRepository userToMicroserviceRepository;
  @Autowired
  ModelMapper modelMapper;

  public Boolean existsUserBoundWithMicroservice
          (Long idUser,
           Long idMicroservice) {
    return userToMicroserviceRepository
            .existsByUserIdAndMicroserviceId(idUser, idMicroservice);
  }

  public void bindUserToMicroservice
          (UserDTO userDTO,
           MicroserviceDTO microserviceDTO,
           AuthInDTO bindAuth) {
    if (!userDTO.getEmail().equals(bindAuth.getEmailUser())) {
      throw new UserNotFoundException("Emails don't match.");
    } else if (!microserviceDTO.getName().equals(
            bindAuth.getNameMicroservice())) {
      throw new MicroserviceNotFoundException(
              "Microservices name don't match.");
    }
    else{
      userToMicroserviceRepository.save(
              new UserToMicroservice(
                      modelMapper.map(userDTO, User.class),
                      modelMapper.map(microserviceDTO,
                              Microservice.class),
                      ERole.USER
              )
      );
    }
  }
}
