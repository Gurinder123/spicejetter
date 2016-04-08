package com.xebia.jetter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan({"com"})
@EnableJpaRepositories({"com"})
public class SpicesuggestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpicesuggestApplication.class, args);
	}
}
