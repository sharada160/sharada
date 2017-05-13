package com.mobi.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mobi.Model.Product;
import com.mobi.Model.Users;
import com.mobi.dao.ProductDao;

public class ProductDaoImpl implements ProductDao {
	@Autowired
	SessionFactory sessionFactory;
	public ProductDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public int SaveOrUpdate(Product product) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().saveOrUpdate(product);
		return 0;
	}
@Transactional
	public List<Product> getAllProduct() {
	@SuppressWarnings("unchecked")
	List<Product> listProduct = (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listProduct;
		// TODO Auto-generated method stub
		
	}

	public Product getProductBy(int productId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	public int deleteProductintById(int productId) {

		Product product = new Product();
		product.setProductid(productId);
		sessionFactory.getCurrentSession().delete(product);
		// TODO Auto-generated method stub
		return 0;
	}

}
