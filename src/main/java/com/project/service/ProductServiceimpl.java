package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Category;
import com.project.model.Product;
import com.project.productDAO.ProductDAO;

@Service
@Transactional

public class ProductServiceimpl implements ProductService {

	public ProductServiceimpl() {
		System.out.println("productserviceimpl object is created");
	}

	@Autowired
	public ProductDAO productDAO;

	public void saveProduct(Product product) {
		productDAO.saveProduct(product);
	}

	public List<Product> getAllProducts() {

		return productDAO.getAllProduct();
	}

	public Product getProductById(int id) {

		return productDAO.getProductById(id);
	}

	public void deleteProduct(int id) {
		Product product = getProductById(id);
		productDAO.deleteProduct(product);

	}

	public void updateProduct(Product product) {
		productDAO.editProduct(product);

	}

	
	public List<Category> getAllCategories() {
		return productDAO.getAllCategories();
	}


}