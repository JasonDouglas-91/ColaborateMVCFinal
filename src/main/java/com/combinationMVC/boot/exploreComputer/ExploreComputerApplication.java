package com.combinationMVC.boot.exploreComputer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExploreComputerApplication {

//	private static final Logger logger  = LoggerFactory.getLogger(ExploreComputerApplication.class);
	public static void main(String[] args) {
//		logger.debug("This is debug.");
		SpringApplication.run(ExploreComputerApplication.class, args);
	}

}
