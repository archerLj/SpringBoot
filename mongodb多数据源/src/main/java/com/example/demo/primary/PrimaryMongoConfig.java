package com.example.demo.primary;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by archerlj on 2017/6/22.
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.example.demo.primary",
        mongoTemplateRef = PrimaryMongoConfig.MONGO_TEMPLATE)
public class PrimaryMongoConfig {

   public static final String MONGO_TEMPLATE = "primaryMongoTemplate";
}
