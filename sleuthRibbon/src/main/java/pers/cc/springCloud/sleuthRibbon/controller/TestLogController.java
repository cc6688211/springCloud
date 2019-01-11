package com.tit.springCloud.sleuthRibbon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestLogController {
	protected final static Logger logger = LoggerFactory.getLogger(TestLogController.class);
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/infoLog-2")
	public String infoLog() {
		logger.info("------infoLog-2------");
		return restTemplate.getForEntity("http://SLEUTH-EUREKA-CLIENT/infoLog-1", String.class).getBody();
	}
}
