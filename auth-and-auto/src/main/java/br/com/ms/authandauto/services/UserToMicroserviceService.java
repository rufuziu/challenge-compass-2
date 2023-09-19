package br.com.ms.authandauto.services;

import br.com.ms.authandauto.dtos.input.userToMicroservice.UserBindToMicroserviceInDTO;
import br.com.ms.authandauto.dtos.output.userToMicroservice.UserBindToMicroserviceOutDTO;
import br.com.ms.authandauto.entities.UserToMicroservice;
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

  public UserBindToMicroserviceOutDTO bindUserToMicroservice
          (UserBindToMicroserviceInDTO bindDto) {
    UserToMicroservice bind = userToMicroserviceRepository
            .save(
                    modelMapper.map(bindDto, UserToMicroservice.class));
    return modelMapper.map(bind, UserBindToMicroserviceOutDTO.class);
  }
}
