package com.ecommerce.shopping.entity;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "category")

public class Category {
	@Id
	@Indexed( unique=true )
	private String categoryId;
	private String categoryName;
	private Date datePosted=new Date();

	
	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String category_id) {
		this.categoryId = category_id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Date getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}
}