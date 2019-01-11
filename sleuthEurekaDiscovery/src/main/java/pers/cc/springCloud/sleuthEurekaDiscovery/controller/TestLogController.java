package pers.cc.springCloud.sleuthEurekaDiscovery.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLogController {
	protected final static Logger logger = LoggerFactory.getLogger(TestLogController.class);

	@GetMapping("/infoLog-1")
	public String infoLog() {
		logger.info("------infoLog-1------");
		return "infoLog";
	}
}
