package br.com.ms.authandauto.services;

import br.com.ms.authandauto.entities.Microservice;
import br.com.ms.authandauto.exceptions.microservice.MicroserviceNotFoundException;
import br.com.ms.authandauto.repositories.MicroserviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MicroserviceService {
  @Autowired
  MicroserviceRepository microserviceRepository;

  public Microservice findById(Long microserviceId) {
    Optional<Microservice> ms = microserviceRepository.findById(microserviceId);
    if(ms.isEmpty())
     throw new MicroserviceNotFoundException("Microservice not found.");
    else return ms.get();
  }
}
