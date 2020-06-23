package com.booking.externalservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.booking.internalclient.BillingAndBookingClient;
import com.booking.internalclient.GetAllRoomClient;
import com.booking.internalclient.GetBookingClient;
import com.booking.internalclient.GetCustomerClient;
import com.booking.internalclient.GetRoomByIdClient;

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
