package com.spring.mongodbconnect;

import com.spring.mongodbconnect.models.Tutorial;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = Tutorial.class)
public class MongodbconnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbconnectApplication.class, args);
	}

}
