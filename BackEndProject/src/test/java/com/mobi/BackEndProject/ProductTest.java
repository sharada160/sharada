package com.mobi.BackEndProject;

import java.util.List;

import org.h2.engine.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mobi.Model.Product;

import com.mobi.dao.ProductDao;


public class ProductTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.mobi.*");
		ctx.refresh();
		System.out.println("Done");
		
		ProductDao productDao=(ProductDao) ctx.getBean("productDao");
		Product product=(Product) ctx.getBean("product");
		
		product.setCategory("tv");
		product.setPrice(50000.000);
		product.setProductname("graphics");
		product.setProductid(0003);
		productDao.SaveOrUpdate(product);
		
	//productDao.deleteProductintById(2);
		
		
		//List<Product> lst=productDao.getAllProduct();
	//	for(Product pro:lst){
	//		System.out.println(pro.getProductid()+" "+pro.getProductname()+" "+pro.getPrice()+" "+pro.getCategory());
		}
	}

