package com.xiyou.pindao;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
// 开启cas的注解
@EnableCasClient
// 开启服务降级
@EnableCircuitBreaker
public class XiyouShopPindaoApplication {
	private static Logger logger = Logger.getLogger(XiyouShopPindaoApplication.class);

	/**
	 * Start
	 */
	public static void main(String[] args) {
		SpringApplication.run(XiyouShopPindaoApplication.class, args);
		logger.info("SpringBoot Start Success");
	}
}
