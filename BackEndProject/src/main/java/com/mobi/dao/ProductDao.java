package com.mobi.dao;

import java.util.List;

import com.mobi.Model.Product;



public interface ProductDao {

	int SaveOrUpdate(Product product);
	List<Product>getAllProduct();
	Product getProductBy(int productId);
	int deleteProductintById(int productId);

}
