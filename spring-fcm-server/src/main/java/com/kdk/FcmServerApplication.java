package com.kdk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class FcmServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FcmServerApplication.class, args);
	}

}
