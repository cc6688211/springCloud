package com.tit.springCloud.ribbon.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestCoontroller {
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return restTemplate.getForEntity("http://EUREKA-CLIENT/dc", String.class).getBody();
	}

	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1() {
		return restTemplate.getForEntity("http://EUREKA-CLIENT-HEALTH/dc", String.class).getBody();
	}
}
