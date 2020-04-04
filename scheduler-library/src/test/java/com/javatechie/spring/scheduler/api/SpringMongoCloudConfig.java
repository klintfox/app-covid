package com.javatechie.spring.scheduler.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClientURI;
import com.world.meter.scheduler.utils.GeneralConstants;

@Configuration
public class SpringMongoCloudConfig {
	public @Bean MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate((MongoDbFactory) new MongoClientURI(GeneralConstants.URI_DEV_CONNECTION));
		return mongoTemplate;

	}
}
