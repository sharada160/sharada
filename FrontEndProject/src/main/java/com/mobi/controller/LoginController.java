package com.mobi.controller;








	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.servlet.ModelAndView;
	import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mobi.Model.Product;
import com.mobi.Model.Users;
import com.mobi.dao.ProductDao;



	@Controller

	public class LoginController {
		
		@Autowired
		Users users;
		@Autowired
		ProductDao productDao;
		

		 //Spring Security related******************************************************************************
		 @RequestMapping("/auth")
			public String getAuthenticate()
			{
				return "auths";
			}
		 @RequestMapping("logins")
			public String getLog()
			{
			 	System.out.println("Logs");
				return "SinglnPage";
			}
		 @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
			public ModelAndView defaultPage() {
			 	System.out.println("Don1");
			 	
				List<Product> plist=productDao.getAllProduct();
				ModelAndView model = new ModelAndView("LandingPage");
				model.addObject("pList", plist);
				System.out.println(plist.size());
				System.out.println("Don2");
				return model;

			}
		 @RequestMapping(value = "/login", method = RequestMethod.GET)
			public String getLogin(@RequestParam(value = "error", required = false) String error,
					@RequestParam(value = "logout", required = false) String logout, final RedirectAttributes redirectAttributes) {
			 		System.out.println("login page");
				ModelAndView model = new ModelAndView();
				String surl="";
				if (error != null) {
					model.addObject("error", "Invalid username and password!");
					System.out.println("Error HERRRRRRRRRe");
//					model.setViewName("SingInPage");
					return "SinglnPage";
				}

				else if (logout != null) {
					model.addObject("msg", "you have loggedout duccessfully");
					System.out.println("LogOut");
//					model.setViewName("LandingPage");
					return "redirect:landing";
					
				}
				else
				{
				System.out.println("some error");
				model.setViewName("auths");
				return "auths";
				}
				

			}
		 
		 

	}


