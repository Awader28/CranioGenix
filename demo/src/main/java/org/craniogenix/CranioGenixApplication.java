package org.craniogenix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "org.craniogenix.repository")

public class CranioGenixApplication {

	public static void main(String[] args) {
		SpringApplication.run(CranioGenixApplication.class, args);
		System.out.println("Rewiring your brains");

	}

}
