package com.wipro.jobpostingfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.wipro.jobpostingfeign.client")
public class JobPostingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobPostingApplication.class, args);
	}

}
