package com.gabrielrosenbach.whorkshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gabrielrosenbach.whorkshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	
}
