package com.boot.challengue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages = {"com.controller","com.dao","com.service"})
@EntityScan (basePackages = {"com.model"})
@EnableJpaRepositories(basePackages = {"com.dao"})
@SpringBootApplication
public class PinAppChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PinAppChallengeApplication.class, args);
	}

}
