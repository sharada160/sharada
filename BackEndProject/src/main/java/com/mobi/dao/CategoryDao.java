package com.mobi.dao;

import java.util.List;

import com.mobi.Model.Category;



public interface CategoryDao {
	int SaveOrUpdate(Category category);
	List<Category>getAllCategory();
	Category getCategoryBy(int categoryId);
	int deleteCategoryintById(int categoryId);
}
