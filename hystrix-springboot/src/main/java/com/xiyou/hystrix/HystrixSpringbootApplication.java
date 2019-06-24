package com.xiyou.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

// springCloudApplication包括服务降级和SpringBootApplication和EnableDiscoveryClient和EnableCircuitBreaker
@SpringCloudApplication
public class HystrixSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixSpringbootApplication.class, args);
	}

}
