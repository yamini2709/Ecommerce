package com.ecommerce.shopping.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shopping.entity.Category;
import com.ecommerce.shopping.repository.CategoryRepository;


@Service
public class CategoryServiceImpl {
	@Autowired
	CategoryRepository categoryRepository;

	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

	public Optional<Category> findById(String categoryId) throws Exception {
		return categoryRepository.findById(categoryId);
	}
	
	public Category editCategory(Category category) {
		return categoryRepository.save(category);
	}

	public void deleteCategory(String categoryId) {
		categoryRepository.deleteById(categoryId);
		
	}

	public void deleteAll() {
		categoryRepository.deleteAll();
	}
}



