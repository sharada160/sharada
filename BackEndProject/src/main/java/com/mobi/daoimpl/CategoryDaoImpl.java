package com.mobi.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mobi.Model.Category;
import com.mobi.Model.Users;
import com.mobi.dao.CategoryDao;

public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	SessionFactory sessionFactory;
	public CategoryDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public int SaveOrUpdate(Category category) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().saveOrUpdate(category);
		return 0;
	}
@Transactional
	public List<Category> getAllCategory() {
	@SuppressWarnings("unchecked")	
	List<Category> listCategory = (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCategory;
		// TODO Auto-generated method stub
		
	}
@Transactional
	public Category getCategoryBy(int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteCategoryintById(int categoryId) {

		Category category = new Category();
		category.setCategoryid(categoryId);
		sessionFactory.getCurrentSession().delete(category);
		// TODO Auto-generated method stub
		return 0;
	}

}
