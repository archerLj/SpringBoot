package com.example.demo.second;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by archerlj on 2017/6/22.
 */

@Configuration
@EnableMongoRepositories(basePackages = "com.example.demo.second",
        mongoTemplateRef = SecondaryMongoConfig.MONGO_TEMPLATE)
public class SecondaryMongoConfig {
    public static final String MONGO_TEMPLATE = "secondaryMongoTemplate";
}
