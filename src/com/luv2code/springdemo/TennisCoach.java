package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// @Component("thatSillyCoach")
@Component // default Component id > tennisCoach
// @Scope("prototype") // default singleton
public class TennisCoach implements Coach {
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	// define
//	@Autowired
//	public void setFortuneService(FortuneService theFortuneService) {
//		System.out.println(">> TennisCoach: inside setFortuneService() method");
//		fortuneService = theFortuneService;
//	}
	
//	@Autowired
//	public void doSomeCrazyStuff(FortuneService theFortuneSerivce) {
//		System.out.println(">> TennisCoach: do some crazy stuff");
//		fortuneService = theFortuneSerivce;
//	}
//	
	
	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("my startup stuff");
	}
	
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("my cleanup stuff");
	}
	
	
	// define my destroy method
	
	
	/*
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
