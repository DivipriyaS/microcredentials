package com.cognizant.microcredentials.premium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = { "com.cognizant.microcredentials.premium" })
@EnableSwagger2
public class PremiumApplication {

	public static void main(String[] args) {
		SpringApplication.run(PremiumApplication.class, args);

	}
}