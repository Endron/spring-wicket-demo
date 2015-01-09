package com.comsysto.wicketBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Class of the Application used to bring up the application Context.ƒ
 */
@SpringBootApplication
public class ApplicationStarter {

	/**
	 * Start Spring Boot Application using Command Line Args.
	 * 
	 * @param args
	 *            Commandline Args
	 */
	public static void main(final String... args) {
		SpringApplication.run(ApplicationStarter.class, args);
	}
}
