package com.ssyedhamed.productapp.dao;

import java.util.List;

import com.ssyedhamed.productapp.entity.Product;

public interface ProductDao {
	
	public int addProduct(Product product);
	public List<Product> getProducts();
	public void deleteProduct(int pid);
	public void updateProduct(Product product);
	public Product getProduct(int pid);
}
