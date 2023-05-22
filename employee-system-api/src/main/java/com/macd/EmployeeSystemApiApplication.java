package com.macd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@SpringBootApplication
public class EmployeeSystemApiApplication {


	public static void main(String[] args) {
		SpringApplication.run(EmployeeSystemApiApplication.class, args);
	}


}
