package com.tit.eurekaDiscoveryHealth.component;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {
	private boolean up = true;

	@Override
	public Health health() {
		if (up) {
			return new Health.Builder().withDetail("aaa_cnt", 10) // 自定义监控内容
					.withDetail("bbb_status", "up").up().build();
		} else {
			return new Health.Builder().withDetail("error", "client is down").down().build();
		}
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

}
