package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// @ComponentScan("com.luv2code.springdemo") // Manually create @Bean
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	
	// define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	
	// define bean for our swim coach and inject dependency
	@Bean
	public Coach swimCoach() { // create 'swimCoach'
		return new SwimCoach(sadFortuneService()); // ref sadFortuneService
	}
	
}
