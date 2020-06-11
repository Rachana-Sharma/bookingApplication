package com.booking.externalService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.booking.internalClient.GenerateBillClient;
import com.booking.internalClient.GetBookingClient;
import com.booking.internalClient.GetCustomerClient;
import com.booking.internalClient.GetRoomClient;
import com.booking.internalClient.SaveBookingClient;

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
	public GetRoomClient client() {
		return new GetRoomClient();
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
	public SaveBookingClient saveBookingClient() {
		return new SaveBookingClient();
	}

	/**
	 * Bean for GetBookingClient
	 */
	@Bean
	public GetBookingClient getBookingClient() {
		return new GetBookingClient();
	}

	/**
	 * Bean for GenerateBillClient
	 */
	@Bean
	public GenerateBillClient generateBillClient() {
		return new GenerateBillClient();
	}
}
