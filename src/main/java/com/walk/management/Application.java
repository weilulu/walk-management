package com.walk.management;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ConfigurationProperties
@EnableAutoConfiguration
@Component
public class Application implements CommandLineRunner{
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	public void run(String... args) throws Exception {
		// nothing to do...
	}
}
