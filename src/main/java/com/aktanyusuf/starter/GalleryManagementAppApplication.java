package com.aktanyusuf.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.aktanyusuf"})
@EntityScan(basePackages = {"com.aktanyusuf"})
@EnableJpaRepositories(basePackages = {"com.aktanyusuf"})
@SpringBootApplication
public class GalleryManagementAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GalleryManagementAppApplication.class, args);
	}

}
