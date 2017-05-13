package com.mobi.BackEndProject;

import java.util.List;

import org.h2.engine.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mobi.Model.Cart;

import com.mobi.dao.CartDao;


public class CartTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.mobi.*");
		ctx.refresh();
		System.out.println("Done");
		
		CartDao cartDao=(CartDao) ctx.getBean("cartDao");
		Cart cart=(Cart) ctx.getBean("cart");
	//	cart.setCartid(76857);
	//	cart.setId_userid(987);
	//	cart.setProductid(80);
	//	cart.setProductname("soap");
	//cart.setProductprice(9076.000);
//		cartDao.SaveOrUpdate(cart);
		cartDao.deleteProductintById(456);
	//	List<Cart> lst=cartDao.getAllCart();
		//for(Cart car:lst){
			//System.out.println(car.getCartid()+" "+car.getId_userid()+" "+car.getProductid()+" "+car.getProductname()+""+car.getProductprice());
		}
	}

