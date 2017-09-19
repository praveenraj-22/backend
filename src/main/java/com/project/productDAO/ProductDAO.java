package com.project.productDAO;
import java.util.List;

import com.project.model.Category;
import com.project.model.Product;

public interface ProductDAO {
void saveProduct(Product product);
List <Product> getAllProduct();
Product getProductById(int id);
void deleteProduct(Product product);
void editProduct(Product product);
List <Category> getAllCategories();

}
