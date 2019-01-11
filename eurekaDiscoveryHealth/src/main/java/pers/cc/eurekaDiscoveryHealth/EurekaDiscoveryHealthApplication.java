package pers.cc.eurekaDiscoveryHealth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaDiscoveryHealthApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaDiscoveryHealthApplication.class, args);
	}
}
