package com.nattahn.shoppingmallbackend.dao;

import java.util.List;

import com.nattahn.shoppingmallbackend.dto.Product;

public interface ProductDAO {
	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	List<Product> getProductsByParam(String param, int count);	
	
	//Business methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLastestActiveProducts(int count);
	
	
}
