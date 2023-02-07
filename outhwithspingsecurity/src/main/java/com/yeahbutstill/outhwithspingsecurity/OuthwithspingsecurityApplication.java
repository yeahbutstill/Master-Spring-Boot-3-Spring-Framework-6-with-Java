package com.yeahbutstill.outhwithspingsecurity;

import com.yeahbutstill.outhwithspingsecurity.service.BusinessService1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OuthwithspingsecurityApplication implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final BusinessService1 businessService1;

	@Autowired
	public OuthwithspingsecurityApplication(BusinessService1 businessService1) {
		this.businessService1 = businessService1;
	}

	public static void main(String[] args) {
		SpringApplication.run(OuthwithspingsecurityApplication.class, args);
	}

	/**
	 * Callback used to run the bean.
	 *
	 * @param args incoming main method arguments
	 * @throws Exception on error
	 */
	@Override
	public void run(String... args) throws Exception {
		logger.info("Value return is {}", businessService1.calculateMax());
	}
}
