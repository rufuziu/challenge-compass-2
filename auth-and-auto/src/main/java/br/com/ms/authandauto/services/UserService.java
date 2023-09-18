package br.com.ms.authandauto.services;

import br.com.ms.authandauto.dtos.input.UserInDTO;
import br.com.ms.authandauto.dtos.output.UserOutDTO;
import br.com.ms.authandauto.entities.User;
import br.com.ms.authandauto.exceptions.user.UserEmailAlreadyInUseException;
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

  public UserOutDTO createUser(UserInDTO userIn) {
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
              , UserOutDTO.class);
    }
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public Optional<User> getUserById(Long id) {
    return userRepository.findById(id);
  }
}
