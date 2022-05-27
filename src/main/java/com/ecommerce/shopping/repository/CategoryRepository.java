package com.ecommerce.shopping.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.shopping.entity.Category;


@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

	Category findByCategoryId(String string);



}
