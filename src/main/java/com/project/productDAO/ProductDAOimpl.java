package com.project.productDAO;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.Category;
import com.project.model.Product;


@Repository("productDAO")

public class ProductDAOimpl implements ProductDAO {

	public ProductDAOimpl()
	{
		System.out.println("product dao impl is created");
	}
	
	
	@Autowired
 public SessionFactory sessionFactory;
	
	public void saveProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		session.save(product);

	}

	
	public List<Product> getAllProduct() {
		
		
		return sessionFactory.getCurrentSession().createQuery("FROM Product",Product.class).list();
	}
	
	
	public Product getProductById(int id) {
		Session session=sessionFactory.getCurrentSession();
		Product products=session.get(Product.class,id);
		return products;
	}
	
	public void deleteProduct(Product product) {
	Session session=sessionFactory.getCurrentSession();
session.delete(product);	
		
	}


	
	public void editProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		session.update(product);
		
	}



	public List<Category> getAllCategories() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Category",Category.class).list();
	}


	


	
	
}


