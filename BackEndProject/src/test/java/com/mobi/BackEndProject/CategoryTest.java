package com.mobi.BackEndProject;

import java.util.List;

import org.h2.engine.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mobi.Model.Category;

import com.mobi.dao.CategoryDao;

public class CategoryTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.mobi.*");
		ctx.refresh();
		System.out.println("Done");
		
		CategoryDao categoryDao=(CategoryDao) ctx.getBean("categoryDao");
		Category category=(Category) ctx.getBean("category");
	//	category.setCategory("gun");
	//	category.setCategoryid(786);
	//	categoryDao.SaveOrUpdate(category);
		categoryDao.deleteCategoryintById(789);
		
		
	//	List<Category> lst=categoryDao.getAllCategory();
		//for(Category ctg:lst){
			//System.out.println(ctg.getCategoryid()+" "+ctg.getCategory());
		}
	}

