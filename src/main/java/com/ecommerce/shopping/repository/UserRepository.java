package com.ecommerce.shopping.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.shopping.entity.Users;
@Repository
public interface UserRepository extends MongoRepository<Users, String> {

	@Query(value = "{'userName':?0}")
	Users findByUserName(String userName);
}




























































