package com.yeahbutstill.oauthwithspingsecurity;

import com.yeahbutstill.oauthwithspingsecurity.service.BusinessService1;
import com.yeahbutstill.oauthwithspingsecurity.service.BusinessService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OAuthwithspingsecurityApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final BusinessService1 businessService1;
	private final BusinessService2 businessService2;

	@Autowired
	public OAuthwithspingsecurityApplication(BusinessService1 businessService1, BusinessService2 businessService2) {
		this.businessService1 = businessService1;
		this.businessService2 = businessService2;
	}

	public static void main(String[] args) {
		SpringApplication.run(OAuthwithspingsecurityApplication.class, args);
	}

	/**
	 * Callback used to run the bean.
	 *
	 * @param args incoming main method arguments
	 * @throws Exception on error
	 */
	@Override
	public void run(String... args) throws Exception {
		logger.info("BusinessService1 Value return is {}", businessService1.calculateMax());
		logger.info("BusinessService2 Value return is {}", businessService2.calculateMin());
	}
}
