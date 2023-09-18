package br.com.ms.authandauto.services;

import br.com.ms.authandauto.dtos.UserDTO;
import br.com.ms.authandauto.entities.User;
import br.com.ms.authandauto.exceptions.user.UserEmailAlreadyUsedException;
import br.com.ms.authandauto.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {
  @Autowired
  UserRepository userRepository;
  @Autowired
  ModelMapper modelMapper;

  public UserDTO createUser(User user){
    if(userRepository.findByEmail(user.getEmail()).isPresent()){
      String message = new StringBuilder()
              .append("Email")
              .append(user.getEmail())
              .append("is already in use.")
              .toString();
      throw new UserEmailAlreadyUsedException(message);
    }
    else{
      return modelMapper.map(userRepository.save(user),UserDTO.class);
    }
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public Optional<User> getUserById(Long id) {
    return userRepository.findById(id);
  }
}
