package com.sadad.spring;

import com.sadad.spring.shared.SpringApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@SpringBootApplication
public class UserServiceJunitDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceJunitDockerApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SpringApplicationContext springApplicationContext() {
		return new SpringApplicationContext();
	}
}
