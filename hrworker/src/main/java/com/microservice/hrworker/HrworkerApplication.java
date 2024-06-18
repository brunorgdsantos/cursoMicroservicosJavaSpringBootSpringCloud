package com.microservice.hrworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class HrworkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrworkerApplication.class, args);
	}

}
