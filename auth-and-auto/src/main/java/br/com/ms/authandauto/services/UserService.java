package br.com.ms.authandauto.services;

import br.com.ms.authandauto.dtos.input.user.UserInDTO;
import br.com.ms.authandauto.dtos.output.microservice.MicroserviceOutDTO;
import br.com.ms.authandauto.dtos.output.user.UserCreatedOutDTO;
import br.com.ms.authandauto.dtos.output.user.UserOutDTO;
import br.com.ms.authandauto.entities.User;
import br.com.ms.authandauto.exceptions.user.UserEmailAlreadyInUseException;
import br.com.ms.authandauto.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;
  @Autowired
  ModelMapper modelMapper;

  public UserCreatedOutDTO createUser(UserInDTO userIn) {
    if (userRepository.findByEmail(userIn.getEmail()).isPresent()) {
      String message = new StringBuilder()
              .append("Email ")
              .append(userIn.getEmail())
              .append(" is already in use.")
              .toString();
      throw new UserEmailAlreadyInUseException(message);
    } else {
      User user = modelMapper.map(userIn, User.class);
      return modelMapper.map(
              userRepository.save(user)
              , UserCreatedOutDTO.class);
    }
  }

  public List<UserOutDTO> getAllUsers() {
    List<User> users = userRepository.findAll();
    List<UserOutDTO> usersDto = new ArrayList<>();
    users.forEach(u -> {
      UserOutDTO uDto = new UserOutDTO(
              u.getName(),
              u.getEmail());
      u.getMicroservices().forEach(
              ms -> {
                MicroserviceOutDTO msDto = new
                        MicroserviceOutDTO(
                        ms.getMicroservice().getName(),
                        ms.getUserRole());
                uDto.getMicroservices().add(msDto);
              });
      usersDto.add(uDto);
    });
    return usersDto;
//    return userRepository.findAll().stream().map(
//            u -> {
//              UserOutDTO uoDto = modelMapper.map(u, UserOutDTO.class);
//              return uoDto;
//            }).toList();
  }

  public Optional<User> getUserById(Long id) {
    return userRepository.findById(id);
  }
}
