package com.springboot.jwt.spring_boot_jwt_mongodb.repository;

import com.springboot.jwt.spring_boot_jwt_mongodb.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

}
