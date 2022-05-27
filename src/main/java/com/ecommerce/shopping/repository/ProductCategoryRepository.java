package com.ecommerce.shopping.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.shopping.entity.Category;
import com.ecommerce.shopping.entity.ProductCategory;

@Repository
public interface ProductCategoryRepository extends MongoRepository<ProductCategory, String> {

	Category findByCategoryId(String string);

}
