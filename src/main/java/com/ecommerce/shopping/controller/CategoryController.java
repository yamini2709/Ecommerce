package com.ecommerce.shopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.shopping.entity.Category;
import com.ecommerce.shopping.serviceImpl.CategoryServiceImpl;


@RestController
public class CategoryController {
	@Autowired
	CategoryServiceImpl categoryService;

	@PostMapping("/addCategory")
	public String saveCategory(@RequestBody Category category) {
		categoryService.saveCategory(category);
		return "Added Successfully";
	}

	@GetMapping("/category-by-id/{categoryId}")
	public Optional<Category> findByUserName(@PathVariable("categoryId") String categoryId) throws Exception {
		return categoryService.findById(categoryId);
	}
	@GetMapping("/categories")
	public List<Category>getCategories(){
		return categoryService.getCategories();
	}
	
	@PutMapping("/updateCategory/{categoryId}")
	public Category updateCategory(@PathVariable String categoryId,@RequestBody Category category) {
		category.setCategoryId(categoryId);
		return categoryService.editCategory(category);		
	}

	@DeleteMapping("/delCategory/{categoryId}")
	public String deleteCategory(@PathVariable String categoryId) {
		categoryService.deleteCategory(categoryId);
		return "Deleted Successfully";
	}
	
	@DeleteMapping("/allCategories")
	public String deleteAllCategories() {
		categoryService.deleteAll();
		return "Deleted all Categories in the database";
	}
}
