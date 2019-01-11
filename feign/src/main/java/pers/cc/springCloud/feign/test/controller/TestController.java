package pers.cc.springCloud.feign.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pers.cc.springCloud.feign.test.service.TestService;

@RestController
public class TestController {
	@Autowired
	TestService testService;

	@GetMapping("/test")
	public Integer test() {
		return testService.add(12, 6);
	}
}
