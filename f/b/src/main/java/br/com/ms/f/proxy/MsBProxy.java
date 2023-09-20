package br.com.ms.f.proxy;

import br.com.ms.f.dtos.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="ms-b",url="localhost:8080")
public interface MsBProxy {
  @GetMapping("/api/users")
  public List<UserDto> listAllUsers();
}
