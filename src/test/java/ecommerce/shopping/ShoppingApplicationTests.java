package ecommerce.shopping;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.shopping.entity.Category;
import com.ecommerce.shopping.entity.ProductCategory;
import com.ecommerce.shopping.repository.CategoryRepository;
import com.ecommerce.shopping.repository.ProductCategoryRepository;

@SpringBootTest
class ShoppingApplicationTests {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	@Test
	public void createProductCategory() {
	ProductCategory pc=new ProductCategory();
	pc.setCategoryId("2");
	pc.setProductId("Sam1");
	pc.setCreatedOn(new Date());
	productCategoryRepository.save(pc);
	assertNotNull(productCategoryRepository.findByCategoryId("2").getCategoryId());
	} 
	
	@Test
	public void createCategory() {
	Category category=new Category();
	category.setCategoryId("1");
	category.setCategoryName("Mobiles");
	category.setDatePosted(new Date());
	categoryRepository.save(category);
	assertNotNull(categoryRepository.findByCategoryId("1").getCategoryId());
	}
	}

	