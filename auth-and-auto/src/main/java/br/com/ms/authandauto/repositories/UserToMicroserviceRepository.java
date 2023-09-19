package br.com.ms.authandauto.repositories;

import br.com.ms.authandauto.entities.UserToMicroservice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserToMicroserviceRepository extends JpaRepository<UserToMicroservice,Long> {
  Optional<UserToMicroservice> findByUserIdAndMicroserviceId(
          Long userId,
          Long microserviceId);
}
