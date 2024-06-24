package com.java.springboot.studentfeignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StudentfeignclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentfeignclientApplication.class, args);
	}

}
