package com.ecommerce.shopping.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shopping.entity.ProductCategory;
import com.ecommerce.shopping.repository.ProductCategoryRepository;

@Service
public class ProductCategoryServiceImpl {
	@Autowired
	ProductCategoryRepository productCategoryRepository;

	public ProductCategory saveProductCategory(ProductCategory productCategory) {
		return productCategoryRepository.save(productCategory);
	}

	public Optional<ProductCategory> findByCategoryId(String categoryId) throws Exception{
		return productCategoryRepository.findById(categoryId);
	}

	public List<ProductCategory> getProductCategories() {
		return productCategoryRepository.findAll();
	}

	public ProductCategory editProductCategoryService(ProductCategory productCategory) {
		return productCategoryRepository.save(productCategory);
	}

	public void deleteProductCategoryService(String categoryId) {
		productCategoryRepository.deleteById(categoryId);
	}

	public void deleteAll() {
		productCategoryRepository.deleteAll();
	}
}
