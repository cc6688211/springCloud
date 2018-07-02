package com.tit.eurekaDiscoveryHealth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tit.eurekaDiscoveryHealth.component.MyHealthIndicator;

@RestController
public class HealthController {
	@Autowired
	MyHealthIndicator myHealthIndicator;

	@RequestMapping("/up")
	public String up(@RequestParam("up") Boolean up) {
		myHealthIndicator.setUp(up);
		return up.toString();
	}

}
