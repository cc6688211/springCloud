package pers.cc.springCloud.turbineStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableTurbineStream
public class TurbineStreamApplication {
	public static void main(String[] args) {
		SpringApplication.run(TurbineStreamApplication.class, args);
	}
}
