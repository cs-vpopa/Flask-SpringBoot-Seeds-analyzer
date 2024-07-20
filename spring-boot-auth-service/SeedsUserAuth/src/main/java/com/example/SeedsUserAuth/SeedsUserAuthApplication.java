package com.example.SeedsUserAuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.SeedsUserAuth")
@EntityScan("com.example.SeedsUserAuth.login")
public class SeedsUserAuthApplication {
	public static void main(String[] args) {
		SpringApplication.run(SeedsUserAuthApplication.class, args);
	}
}
