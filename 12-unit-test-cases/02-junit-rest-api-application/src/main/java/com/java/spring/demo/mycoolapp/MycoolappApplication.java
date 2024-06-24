package com.java.spring.demo.mycoolapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class MycoolappApplication {
	public static void main(String[] args) {
		SpringApplication.run(MycoolappApplication.class, args);
	}
}
