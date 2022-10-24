package com.ssyedhamed.productapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssyedhamed.productapp.entity.Product;
@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private HibernateTemplate template;
	

	public int addProduct(Product product) {
		return (Integer) this.template.save(product);
	}
	
	public List<Product> getProducts() {
		List<Product> products = this.template.loadAll(Product.class);
		return products;
	}

	public void deleteProduct(int pid) {
		Product p=this.template.load(Product.class, pid);
		this.template.delete(p);
		
	}
	
	
	
	public Product getProduct(int pid) {
		
		Product p=this.template.get(Product.class, pid);
		return p;
	}

	public void updateProduct(Product product) {
		this.template.update(product);
		
	}
	



	
}
