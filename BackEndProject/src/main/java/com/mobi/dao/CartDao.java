package com.mobi.dao;

import java.util.List;

import com.mobi.Model.Cart;



public interface CartDao {
	int SaveOrUpdate(Cart cart);
	List<Cart>getAllCart();
	Cart getProductBy(int cartId);
	int deleteProductintById(int cartId);

}
