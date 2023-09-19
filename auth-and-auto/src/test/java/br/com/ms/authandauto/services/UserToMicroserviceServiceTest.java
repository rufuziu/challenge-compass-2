package br.com.ms.authandauto.services;

import br.com.ms.authandauto.dtos.input.UserBindToMicroserviceInDTO;
import br.com.ms.authandauto.dtos.output.UserBindToMicroserviceOutDTO;
import br.com.ms.authandauto.entities.UserToMicroservice;
import br.com.ms.authandauto.repositories.UserToMicroserviceRepository;
import br.com.ms.authandauto.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserToMicroserviceServiceTest {
  @InjectMocks
  private UserToMicroserviceService userToMicroserviceService;
  @Mock
  private UserToMicroserviceRepository userToMicroserviceRepository;
  @Spy
  private ModelMapper modelMapper;

  private static final String USER_TO_MICROSERVICE =
          "payloads/userToMicroservice/userToMicroservice.json";

  @Test
  void bindUserToMicroservice() throws IOException {
    //given
    UserToMicroservice userToMicroservice = JsonUtils.getObjectFromFile(
            USER_TO_MICROSERVICE, UserToMicroservice.class);
    UserBindToMicroserviceInDTO bindDto = modelMapper.map(
            userToMicroservice,UserBindToMicroserviceInDTO.class);
    when(userToMicroserviceRepository.save(any())).thenReturn(userToMicroservice);
    //then
    UserBindToMicroserviceOutDTO response =
            userToMicroserviceService.bindUserToMicroservice(bindDto);
    //verify
    assertAll("UserToMicroservice bind Payload",
            () -> assertEquals("test@email.com", response.getEmailUser()),
            () -> assertEquals("ms-test", response.getNameMicroservice()));
  }
}