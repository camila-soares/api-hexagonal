package com.github.api.hexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.github.api.hexagonal")
@EnableFeignClients(basePackages = "com.github.api.hexagonal.adapters.out.client")
public class ApiHexagonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiHexagonalApplication.class, args);
	}

}
