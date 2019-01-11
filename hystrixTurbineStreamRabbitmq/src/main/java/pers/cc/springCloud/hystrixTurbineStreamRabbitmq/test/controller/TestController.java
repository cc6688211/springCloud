package pers.cc.springCloud.hystrixTurbineStreamRabbitmq.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TestController {
	@Autowired
	TestService testService;
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return testService.test();
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return restTemplate.getForObject("http://EUREKA-CLIENT//add?a=12&b=6", String.class);
	}

	@Service
	class TestService {
		@Autowired
		RestTemplate restTemplate;

		@HystrixCommand(fallbackMethod = "fallback")
		public String test() {
			return restTemplate.getForObject("http://EUREKA-CLIENT/stop", String.class);
		}

		public String fallback() {
			return "fallback";
		}

	}
}
