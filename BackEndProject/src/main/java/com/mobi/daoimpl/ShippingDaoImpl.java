package com.mobi.daoimpl;

import java.util.List;

import javax.swing.plaf.basic.BasicListUI.ListSelectionHandler;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mobi.Model.Product;
import com.mobi.Model.Shipping;
import com.mobi.Model.Users;
import com.mobi.dao.ShippingDao;

public class ShippingDaoImpl implements ShippingDao {
	@Autowired
	SessionFactory sessionFactory;
	public ShippingDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public int SaveOrUpdate(Shipping shipping) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().saveOrUpdate(shipping);
		return 0;
	}
	@Transactional
	public List<Shipping> getAllShipping() {
		@SuppressWarnings("unchecked")
		List<Shipping> listShipping = (List<Shipping>) sessionFactory.getCurrentSession().createCriteria(Shipping.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		// TODO Auto-generated method stub
		return listShipping;
	}
	public Shipping getShippingBy(int shippingId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	public int deleteShippingById(int shippingId) {

		Shipping shipping = new Shipping();
		shipping.setShippingid(shippingId);
		sessionFactory.getCurrentSession().delete(shipping);
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		return 0;
	}
	}
	
	


