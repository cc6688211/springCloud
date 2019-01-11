package pers.cc.springCloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import pers.cc.springCloud.zuul.filter.AccessTokenFilter;
import pers.cc.springCloud.zuul.filter.AccessTokenFilter1;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}

	// 配置过滤器
	@Bean
	public AccessTokenFilter accessTokenFilter() {
		return new AccessTokenFilter();
	}

	// 配置多个过滤器
	@Bean
	public AccessTokenFilter1 accessTokenFilter1() {
		return new AccessTokenFilter1();
	}
}
