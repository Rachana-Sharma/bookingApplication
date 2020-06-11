package com.booking.internalClient;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.booking.common.BillingRequest;

/**
 * @author Rachana Sharma
 * GenerateBillClient
 */
public class GenerateBillClient {

	/**
	 * RestTemplate
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	public double generateBillClientMethod(BillingRequest billingRequest) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<BillingRequest> entity = new HttpEntity<BillingRequest>(billingRequest,headers);
		double result= restTemplate.exchange("http://localhost:8080/bill", HttpMethod.POST, entity, Double.class).getBody();
		return result;
	}
}
