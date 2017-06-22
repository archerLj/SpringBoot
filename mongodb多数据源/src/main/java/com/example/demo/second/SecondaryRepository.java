package com.example.demo.second;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by archerlj on 2017/6/22.
 */
public interface SecondaryRepository extends MongoRepository<SecondaryMongoObject, String> {
}
