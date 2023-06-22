package com.proyecto.monederos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MonederosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonederosApplication.class, args);
	}

}
