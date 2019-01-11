package pers.cc.springCloud.hystrix.test.controller;

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

	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1() {
		return testService.test1();
	}

	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test2() {
		return restTemplate.getForObject("http://EUREKA-CLIENT/stop", String.class);
	}

	@Service
	class TestService {
		@Autowired
		RestTemplate restTemplate;

		// 使用@HystrixCommand注解指定接口降级处理方法
		@HystrixCommand(fallbackMethod = "fallback")
		public String test() {
			return restTemplate.getForObject("http://EUREKA-CLIENT/stop", String.class);
		}

		@HystrixCommand(fallbackMethod = "fallback")
		public String test1() {
			return restTemplate.getForObject("http://EUREKA-CLIENT/stop", String.class);
		}

		public String fallback() {
			return "fallback";
		}

	}
}
