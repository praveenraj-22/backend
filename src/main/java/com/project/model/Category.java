package com.project.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	private String categoryName;
	@OneToMany(mappedBy="category")
	private List<Product> product;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<Product> getProducts() {
		return product;
	}
	public void setProducts(List<Product> product) {
		this.product = product;
	}
	
	@Override
	public String toString()
	{
		return this.cid +""+ this.categoryName;
		
	}
	
	
	
	
}
