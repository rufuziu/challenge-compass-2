package br.com.ms.f.proxy;

import br.com.ms.f.dtos.MicroserviceDto;
import br.com.ms.f.dtos.output.UserWithMicroservicesAndRolesOutDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-f", url = "localhost:8080")
public interface MsAProxy {
  @GetMapping("/api/users")
  public List<UserWithMicroservicesAndRolesOutDTO>
  getAllUsersWithMicroservicesAndRoles();

  @GetMapping("/api/users/microservice/{id-microservice}")
  public MicroserviceDTO getMicroserviceAndUsers(
          @PathVariable("id-microservice") Long id);
}