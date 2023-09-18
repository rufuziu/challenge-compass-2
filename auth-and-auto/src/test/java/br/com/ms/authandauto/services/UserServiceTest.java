package br.com.ms.authandauto.services;

import br.com.ms.authandauto.dtos.input.UserInDTO;
import br.com.ms.authandauto.dtos.output.UserOutDTO;
import br.com.ms.authandauto.entities.User;
import br.com.ms.authandauto.exceptions.user.UserEmailAlreadyInUseException;
import br.com.ms.authandauto.repositories.UserRepository;
import br.com.ms.authandauto.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
  @InjectMocks
  private UserService userService;
  @Mock
  private UserRepository userRepository;
  @Spy
  private ModelMapper modelMapper;

  private static final String USER = "payloads/user/createUser.json";
  private static final String USERS = "payloads/user/listOfUser.json";


  @Test
  void createUser() throws IOException {
    //given
    User user = JsonUtils.getObjectFromFile(USER, User.class);
    UserInDTO userIn = modelMapper.map(user, UserInDTO.class);
    UserOutDTO userOut = modelMapper.map(user, UserOutDTO.class);
    when(userRepository.findByEmail(any())).thenReturn(Optional.empty());
    when(userRepository.save(any())).thenReturn(user);
    //then
    UserOutDTO response = userService.createUser(userIn);
    //verify
    assertAll("User created Payload",
            () -> assertEquals(1, response.getId()),
            () -> assertEquals("Test", response.getName()),
            () -> assertEquals("test@email.com", response.getEmail()));
  }
  @Test
  void userEmailAlreadyInUse() throws IOException {
    //given
    User user = JsonUtils.getObjectFromFile(USER, User.class);
    UserInDTO userIn = modelMapper.map(user, UserInDTO.class);
    when(userRepository.findByEmail(any()))
            .thenReturn(Optional.of(user));
    //then
    assertThrows(UserEmailAlreadyInUseException.class,
            ()-> userService.createUser(userIn));
  }

  @Test
  void getAllUsers() throws IOException {
    //given
    List<User> users = JsonUtils.getListOfObjectFromFile(USERS, User.class);
//    List<UserDTO> usersDTO = users.stream().map(
//            u->modelMapper.map(u,UserDTO.class))
//            .toList();
    when(userRepository.findAll()).thenReturn(users);
    //then
    List<User> response = userService.getAllUsers();
    //verify
    assertAll("User List Payload",
            () -> assertEquals(3, response.size()),
            () -> assertEquals(2, response.get(1).getId()));
  }

  @Test
  void getUserById() {
  }
}