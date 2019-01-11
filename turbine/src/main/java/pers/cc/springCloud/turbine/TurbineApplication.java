package pers.cc.springCloud.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableTurbine
public class TurbineApplication {
	public static void main(String[] args) {
		SpringApplication.run(TurbineApplication.class, args);
	}
}
