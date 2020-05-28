package com.booking.externalService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import com.booking.internalClient.BookingClient;

/**
 * @author Rachana Sharma The ExternalServiceApplication
 */
@SpringBootApplication
@ComponentScan("com.booking")
@EnableJpaRepositories(basePackages = "com.booking.common")
@EnableTransactionManagement
@EntityScan(basePackages = "com.booking.common")
public class ExternalServiceApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(ExternalServiceApplication.class, args);
	}

	/**
	 * RestTemplate
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * Client
	 */
	@Bean
	public BookingClient client() {
		return new BookingClient();
	}

	/**
	 * External Service
	 */
	public ExternalService externalService() {
		return new ExternalService();
	}

}
