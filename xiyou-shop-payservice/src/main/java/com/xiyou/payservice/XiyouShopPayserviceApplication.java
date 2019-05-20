package com.xiyou.payservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import java.util.logging.Logger;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
public class XiyouShopPayserviceApplication {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(XiyouShopPayserviceApplication.class);

	/**
	 * Start
	 */
	public static void main(String[] args) {
		SpringApplication.run(XiyouShopPayserviceApplication.class, args);
	}
}
