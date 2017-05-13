package com.mobi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mobi.Model.Product;
import com.mobi.dao.ProductDao;



@Controller
public class HomeController {

	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	@RequestMapping("/")
	public String getLandingPage(){
		return "Header";
	}
	@RequestMapping("LandingPage")
	public String getTestPage(){
		return "Header";
	}
		@RequestMapping("/home")
		public ModelAndView getHome()
		{
			ModelAndView mv=new ModelAndView("home");
			List<Product> plist=productDao.getAllProduct();
			mv.addObject("pList", plist);
			System.out.println(plist.size());
			mv.addObject("msg", "Hello world");
			return mv;
		}
	
}
