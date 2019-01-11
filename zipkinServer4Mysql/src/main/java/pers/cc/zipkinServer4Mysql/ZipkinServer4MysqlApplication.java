package pers.cc.zipkinServer4Mysql;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import zipkin.server.internal.EnableZipkinServer;
import zipkin2.storage.mysql.v1.MySQLStorage;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinServer4MysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServer4MysqlApplication.class, args);
	}

	@Bean
	public MySQLStorage mySQLStorage(DataSource datasource) {
		return MySQLStorage.newBuilder().datasource(datasource).executor(Runnable::run).build();
	}
}
