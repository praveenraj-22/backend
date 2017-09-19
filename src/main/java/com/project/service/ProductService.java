package com.project.service;

import java.util.List;

import com.project.model.Category;
import com.project.model.Product;

public interface ProductService {

	void saveProduct(Product product);

	List<Product> getAllProducts();

	Product getProductById(int id);

	void deleteProduct(int id);

	void updateProduct(Product product);

	List<Category> getAllCategories();
	
	

}
