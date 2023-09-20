package br.com.ms.f;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class F_Application {

	public static void main(String[] args) {
		SpringApplication.run(F_Application.class, args);
	}

}
