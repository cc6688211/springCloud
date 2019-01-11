package pers.cc.zipkinServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinServerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}
}
