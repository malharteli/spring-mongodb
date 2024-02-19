package com.spring.mongodbconnect;

import com.spring.mongodbconnect.models.Tutorial;
import com.spring.mongodbconnect.repositories.TutorialRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableMongoRepositories(basePackageClasses = TutorialRepo.class)
public class MongodbconnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbconnectApplication.class, args);
	}

}
