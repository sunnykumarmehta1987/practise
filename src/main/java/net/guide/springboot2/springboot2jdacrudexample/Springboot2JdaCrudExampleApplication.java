package net.guide.springboot2.springboot2jdacrudexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@ComponentScan(basePackages = { "net.guide.springboot2.controller","net.guide.springboot2.model","net.guide.springboot2.repository"} )
@EntityScan("net.guide.springboot2.model")
@EnableJpaRepositories("net.guide.springboot2.repository")
public class Springboot2JdaCrudExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2JdaCrudExampleApplication.class, args);
	}

}
