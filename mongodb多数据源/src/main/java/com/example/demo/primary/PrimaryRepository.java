package com.example.demo.primary;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by archerlj on 2017/6/22.
 */
public interface PrimaryRepository extends MongoRepository<PrimaryMongoObject, String> {
}
