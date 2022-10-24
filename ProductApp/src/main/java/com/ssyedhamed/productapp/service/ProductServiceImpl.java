package com.ssyedhamed.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssyedhamed.productapp.dao.ProductDao;
import com.ssyedhamed.productapp.entity.Product;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;
	@Transactional
	public int addProduct(Product product) {
		return this.productDao.addProduct(product);
		
	}

	public List<Product> getProducts() {
		return this.productDao.getProducts();
	}

	
@Transactional
	public void deleteProduct(int pid) {
		this.productDao.deleteProduct(pid);
		
	}


public Product getProduct(int pid) {
	return this.productDao.getProduct(pid);
}

@Transactional
public void updateProduct(Product product) {
	this.productDao.updateProduct(product);
	
}

}
