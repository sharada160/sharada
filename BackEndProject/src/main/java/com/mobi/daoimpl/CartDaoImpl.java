package com.mobi.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mobi.Model.Cart;
import com.mobi.Model.Users;
import com.mobi.dao.CartDao;


public class CartDaoImpl implements CartDao{
	@Autowired
	SessionFactory sessionFactory;
	public CartDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public int SaveOrUpdate(Cart cart) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return 0;
	}
@Transactional
	public List<Cart> getAllCart() {
	@SuppressWarnings("unchecked")	
	List<Cart> listCart = (List<Cart>) sessionFactory.getCurrentSession().createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCart;
	
	}

	public Cart getProductBy(int cartId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	public int deleteProductintById(int cartId) {

		Cart cart = new Cart();
		cart.setCartid(cartId);
		sessionFactory.getCurrentSession().delete(cart);
		// TODO Auto-generated method stub
		return 0;
	

		
	

		
	}

}
