package com.mobi.BackEndProject;

import java.util.List;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mobi.Model.Shipping;
import com.mobi.dao.ShippingDao;



public class ShippingTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.mobi.*");
		ctx.refresh();
		System.out.println("Done");
		
		ShippingDao shippingDao=(ShippingDao) ctx.getBean("shippingDao");
		Shipping shipping=(Shipping) ctx.getBean("shipping");
shipping.setUserid(3);
shipping.setArea("rome");
shipping.setCity("usa");
shipping.setContact("phone");
shipping.setFirstname("priya");
shipping.setLastname("jain");
shipping.setShippingid(0010);
shipping.setLoginid(4003);
shipping.setPincode(56078);

shippingDao.SaveOrUpdate(shipping);

		
		
		
			
	//	List<Shipping> lst=shippingDao.getAllShipping();
	//	for(Shipping shi:lst){
	//		System.out.println(shi.getUserid()+" "+shi.getFirstname()+" "+shi.getLastname()+" "+shi.getContact()+""+shi.getShipping()+""+shi.getArea()+""+
	//	shi.getCity()+""+shi.getPincode());
		}
	}

