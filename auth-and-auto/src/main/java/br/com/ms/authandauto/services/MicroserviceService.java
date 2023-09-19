package br.com.ms.authandauto.services;

import br.com.ms.authandauto.dtos.microservice.MicroserviceDTO;
import br.com.ms.authandauto.entities.Microservice;
import br.com.ms.authandauto.exceptions.microservice.MicroserviceNotFoundException;
import br.com.ms.authandauto.repositories.MicroserviceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MicroserviceService {
  @Autowired
  MicroserviceRepository microserviceRepository;
  @Autowired
  ModelMapper modelMapper;

  public MicroserviceDTO getMicroserviceById(Long microserviceId) {
    Optional<Microservice> ms = microserviceRepository.findById(microserviceId);
    if(ms.isEmpty()){
      String message = new StringBuilder()
              .append("Microservice not found. id: ")
              .append(microserviceId).toString();
      throw new MicroserviceNotFoundException(message);
    }
    else return modelMapper.map(ms.get(), MicroserviceDTO.class);
  }

}
