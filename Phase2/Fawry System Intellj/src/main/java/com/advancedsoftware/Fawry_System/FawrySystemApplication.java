package com.advancedsoftware.Fawry_System;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FawrySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(FawrySystemApplication.class, args);
	}

}
