package com.booking.externalService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.booking.internalClient.BookingClient;

/**
 * @author Rachana Sharma ConfigurationClass
 */
@Configuration
public class ConfigurationClass {

	/**
	 * Bean for RestTemplate
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * Bean for Client
	 */
	@Bean
	public BookingClient client() {
		return new BookingClient();
	}

	/**
	 * Bean for External Service
	 */
	
	public ExternalService externalService() {
		return new ExternalService();
	}
}
