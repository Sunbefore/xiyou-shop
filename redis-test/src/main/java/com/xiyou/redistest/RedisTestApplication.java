package com.xiyou.redistest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class RedisTestApplication {


	/**
	 * Start
	 */
	public static void main(String[] args) {
		SpringApplication.run(RedisTestApplication.class, args);
	}

}
