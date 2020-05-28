package com.booking.internalService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

/**
 * @author Rachana Sharma The InternalServiceApplication
 */
@SpringBootApplication
@ComponentScan("com.booking")
@EnableJpaRepositories(basePackages = "com.booking.common")
@EnableTransactionManagement
@EntityScan(basePackages = "com.booking.common")
public class InternalServiceApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(InternalServiceApplication.class, args);
	}

	/**
	 * bean for RestTemplate
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
