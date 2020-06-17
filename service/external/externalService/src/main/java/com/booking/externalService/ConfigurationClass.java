package com.booking.externalService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.booking.internalClient.BillingAndBookingClient;
import com.booking.internalClient.GetAllRoomClient;
import com.booking.internalClient.GetBookingClient;
import com.booking.internalClient.GetCustomerClient;
import com.booking.internalClient.GetRoomByIdClient;

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
	 * Bean for GetRoomClient
	 */
	@Bean
	public GetRoomByIdClient client() {
		return new GetRoomByIdClient();
	}

	/**
	 * Bean for External Service
	 */

	public ExternalService externalService() {
		return new ExternalService();
	}

	/**
	 * Bean for GetCustomerClient
	 */
	@Bean
	public GetCustomerClient getCustomerClient() {
		return new GetCustomerClient();
	}

	/**
	 * Bean for SaveCustomerClient
	 */
	@Bean
	public BillingAndBookingClient saveBookingClient() {
		return new BillingAndBookingClient();
	}

	/**
	 * Bean for GetBookingClient
	 */
	@Bean
	public GetBookingClient getBookingClient() {
		return new GetBookingClient();
	}
	/**
	 * Bean for GetAllRoomClient
	 */
	@Bean
	public GetAllRoomClient getAllRoomClient() {
		return new GetAllRoomClient();
	}
}
