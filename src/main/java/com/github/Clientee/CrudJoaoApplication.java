package com.github.Clientee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CrudJoaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudJoaoApplication.class, args);
	}

}
