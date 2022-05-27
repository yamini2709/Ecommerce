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

import com.ecommerce.shopping.entity.ProductCategory;
import com.ecommerce.shopping.serviceImpl.ProductCategoryServiceImpl;

@RestController
public class ProductCategoryController {
	@Autowired
	ProductCategoryServiceImpl productCategoryService;

	@PostMapping("/addProductCategory")
	public String saveProductCategory(@RequestBody ProductCategory productCategory) {
		productCategoryService.saveProductCategory(productCategory);
		return "Added Successfully";
	}

	@GetMapping("/productCategory-by-id/{categoryId}")
	public Optional<ProductCategory> findByUserName(@PathVariable("categoryId") String categoryId) throws Exception {
		return productCategoryService.findByCategoryId(categoryId);
	}
	@GetMapping("/productCategories")
	public List<ProductCategory>getProductCategories(){
		return productCategoryService.getProductCategories();
	}
	
	@PutMapping("updateProductCategory/{categoryId}")
	public ProductCategory updateProductCategoryService(@PathVariable String categoryId,@RequestBody ProductCategory productCategory) {
		productCategory.setCategoryId(categoryId);
		return productCategoryService.editProductCategoryService(productCategory);		
	}

	@DeleteMapping("/delProductCategory/{categoryId}")
	public String deleteProductCategoryService(@PathVariable String categoryId) {
		productCategoryService.deleteProductCategoryService(categoryId);
		return "Deleted Successfully";
	}
	@DeleteMapping("/allProductCategories")
	public String deleteAll() {
		productCategoryService.deleteAll();
		return "Deleted all Product Categories in the database";
	}
}
