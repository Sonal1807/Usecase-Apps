package com.menuservice.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableAutoConfiguration
@SpringBootApplication
@EnableEurekaClient
public class MenuserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuserviceApplication.class, args);
	}

}
