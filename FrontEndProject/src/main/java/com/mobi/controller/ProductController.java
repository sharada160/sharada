package com.mobi.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.mobi.Model.Cart;
import com.mobi.Model.Category;
import com.mobi.Model.Product;
import com.mobi.Model.Shipping;
import com.mobi.Model.Users;
import com.mobi.dao.CartDao;
import com.mobi.dao.CategoryDao;
import com.mobi.dao.ProductDao;
import com.mobi.dao.ShippingDao;
import com.mobi.dao.UserDao;



@Controller
	public class ProductController {

		@Autowired
		ProductDao productDao;
		
		@Autowired
		Product product;
		
		@Autowired
		CartDao cartDao;
		
		@Autowired
	    Cart cart;
		
		
		
		@Autowired
		CategoryDao categoryDao;
		
		@Autowired
		Category category;
		
		@Autowired
		UserDao userdao;
		
		@Autowired
		Shipping shipping;
		
		@Autowired
		UserDao usersDao;
		
		@Autowired
		Users users;
		
//		saveProduct
		
		@RequestMapping("addProduct")
		public ModelAndView addproduct(@ModelAttribute("prod")Product product)
		{
			ModelAndView mv=new  ModelAndView("AddProduct");
			mv.addObject("prod",product);
			return mv;
		}
	@RequestMapping("saveProduct")
	public String savingProduct(@ModelAttribute("prod") Product prod,HttpServletRequest request, final RedirectAttributes redirectAttributes){
			
			ModelAndView mv=new ModelAndView();
			int count=0;
			System.out.println(prod.getCategory()+" "+prod.getProductname());
			productDao.SaveOrUpdate(prod);
			
			mv.addObject("success", "Product Data Inserted Succefully");
			
			//MultipartFile itemimage=product.getImg();
		//	String rootdir=request.getSession().getServletContext().getRealPath("/");
		//	System.out.println("UUUUUUUUUUUUUUUUU "+rootdir);
			//Path path = Paths.get(rootdir+"resources/includes/im/"+product.getProductId()+".jpg");
			
//			if(itemimage!=null && !itemimage.isEmpty()){
//				try{
//					System.out.println("OOOOOOOOOOOOOOOO "+path.toString());
//					itemimage.transferTo(path.toFile());
//					
//				}
//				catch(Exception e)
//				{
//					e.printStackTrace();
//					throw new RuntimeException("product image saving failed", e);
//				}
//			}
//			
	
		return "redirect:plisting";
	}
		


			
//		CART
		
//		@RequestMapping("addCart")	
//		public String addToCart(@RequestParam(value="Id", required=true) int Id,@RequestParam(value="usr") String usr, final RedirectAttributes redirectAttributes)
//		{
//		//	product=productDao.getProductBy(productid);
//			List<Cart> clist=cartDao.getAllCart();
//			int cnt=clist.size();
//			cnt=cnt+1;
//			cart.setCartid(cnt);
//			cart.setProductname(usr);
//			cart.setCartid(product.getProductid());
//			cart.setProductname(product.getProductname());
//			cart.setProductprice(product.getPrice());
////			cart.setId_userId(usr);
//			cartDao.SaveOrUpdate(cart);
//			return "redirect:prodETAIL?Id="+Id;
//		}
  @RequestMapping("saveCart")
	   public String savingCart(@ModelAttribute("cart") Cart cart, final RedirectAttributes redirectAttributes){
			ModelAndView mv=new ModelAndView("FormAddCart");
			int count=0;
			System.out.println(cart.getProductname()+" "+cart.getCartid());
			count=cartDao.SaveOrUpdate(cart);
//			
		if(count>0){mv.addObject("success", "CartData Inserted Succefully");}
			
		return "redirect:/prodETAIL?Id";
		
	}
//	   
//	   //Category
//	   
//	   @RequestMapping("addCategory")
//	   public ModelAndView addCategory(@RequestParam(value="Id", required=true) int productId, final RedirectAttributes redirectAttributes)
//		{
//			ModelAndView mv=new ModelAndView("FormAddCategory");
//	       mv.addObject("category", category);
//			return mv;
//		}
//	//  @RequestMapping("saveCategory")
//	//  public String savingCategory(@ModelAttribute("category") Category category, final RedirectAttributes redirectAttributes)
//	  {
//			ModelAndView mv=new ModelAndView("FormAddCategory");
//			int count=0;
//			System.out.println(category.getCategoryid()+" "+category.getCategory());
//			count=categoryDao.SaveOrUpdate(category);
//			if(count>0){mv.addObject("success", "Category Data Inserted Succefully");}
//			
//			return "redirect:addCategory";
//	}
//	  
//	  //SHIPPING
//	  
//	  @RequestMapping("shippingDetail")
//	  public ModelAndView addShippingDetail(@ModelAttribute("shippingdetail") Shipping shipping)
//	 	{
//	 		ModelAndView mv=new ModelAndView("AddShipping");
//	        mv.addObject("shippingdetail", shipping);
//	 		return mv;
//	 	}
//  @RequestMapping("saveUserDetail")
//	   public String savingUserDetail(@ModelAttribute("userdetail") ShippingDao userDetail, final RedirectAttributes redirectAttributes)
//	   {
//	 		ModelAndView mv=new ModelAndView("FormAddUserDetail");
//	 		int count=0;
//	 		System.out.println(userDetail.getuserid()+" "+userDetail.getfirstname());
//	 		count=shippingDao.saveOrUpdate(shippingDetail);
// 		
//	 	if(count>0){mv.addObject("success", "Users Data Inserted Succefully");}
//	 		
//	 		return "redirect:addUserDetail";
//	 }
//	   
	   @RequestMapping("plisting")
	   public ModelAndView getAllProduct()
	   {
		   ModelAndView mv=new ModelAndView("ProductTable");
		   List<Product> plist=productDao.getAllProduct();
		   mv.addObject("pList", plist);
		   return mv;
 }
//	   
//	   @RequestMapping("listing")
//	   public ModelAndView getAllCart()
//	   {
//		   ModelAndView mv=new ModelAndView("TableCart");
//		   List<Cart> clist=cartDao.getAllCart();
//		   mv.addObject("cList", clist);
//		   return mv;
//	   }
//	   @RequestMapping("prodETAIL")
//	   public ModelAndView getProDetails(@RequestParam(value="Id", required=true) int productId,final RedirectAttributes redirectAttributes)
//	{
//		   product=productDao.getByProductId(productId);
//		   ModelAndView mv=new ModelAndView("ProductDetails");
//		   mv.addObject("product",product);
//		   return mv;
//	}
//
//	   
//	   @RequestMapping("backtoHome")
//	   public String getBackToHome(final RedirectAttributes redirectAttributes)
//	   {
//		   return "redirect:/";
//	   }
//	   
//	   @RequestMapping("totablecart")
//	   public ModelAndView getToTableCart()
//	   {
//		   ModelAndView mv=new ModelAndView("TableCart");
//		   List<Cart> clist=cartDao.getAllCart();
//		   mv.addObject("cList", clist);
//		   return mv;
//	   }
//	   @RequestMapping("backtotablecart")
//	   public ModelAndView getbackToTableCart()
//	   {
//		   ModelAndView mv=new ModelAndView("TableCart");
//		   List<Cart> clist=cartDao.getAllCart();
//		   mv.addObject("cList", clist);
//		   return mv;
//	   }
//	   @RequestMapping("supplier/edit.do")
//	   public ModelAndView getEditProduct(@RequestParam(value="Id", required=true) int productId,final RedirectAttributes redirectAttributes)
//	   {
//		   product=productDao.getByProductId(productId);
//		   System.out.println("ddddddddddddddddd"+product.getProductName());
//		   ModelAndView mv=new ModelAndView("FormAddProduct");
//		   mv.addObject("prod",product);
//		   return mv;
//	   }
//	   @RequestMapping("FormAddProduct")
//	   public ModelAndView takeForm()
//	   {
//		   ModelAndView mv=new ModelAndView("FormAddProduct");
//		   return mv;   
//	   }
//	   @RequestMapping("del.do")                         
//	   public String getDelProduct(@RequestParam(value="Id", required=true) int productId,final RedirectAttributes redirectAttributes)
//	   {
//		   int x=productDao.deleteById(productId);
//		   System.out.println("deleted "+productId);
//		   return "redirect:listig";
//	   }
//	   @RequestMapping("toformadduserdetail")
//	   public ModelAndView getUserDetail(@ModelAttribute("userdetail") UserDetail userdetail)
//	  	{
//	  		ModelAndView mv=new ModelAndView("FormAddUserDetail");
//	         mv.addObject("userdetail", userdetail);
//	  		return mv;
//	  	}
//	   @RequestMapping("gotosinginpage")
//	   public ModelAndView getSingInPage()
//	   {
//		   ModelAndView mv=new ModelAndView("SingInPage");
//		    return mv;
//	   }
//	   @RequestMapping("saveUserDetail")
//	   public ModelAndView sendUserDetail(@ModelAttribute("userdetail") UserDetail userDetail, final RedirectAttributes redirectAttributes)
//	   {
//	 		ModelAndView mv=new ModelAndView("FormAddUserDetail");
//	 		int count=0;
//	 		System.out.println(userDetail.getUserId()+" "+userDetail.getFirstname());
//	 		count=userdetailDao.saveOrUpdate(userDetail);
//	 		
//	 	if(count>0){mv.addObject("success", "Users Data Inserted Succefully");}
//	 		
//	 		return mv;
//	 }
//	//   @RequestMapping("tocarttable")
//	//   public ModelAndView gettocarttable()
//	//   {
////		   ModelAndView mv=new ModelAndView("TableCart");
////		   List<Cart> clist=cartDao.getAllCart();
////		   mv.addObject("cList", clist);
////		   return mv;
//	//   }
//	   
//	//   @RequestMapping("gotouserdetails")
//	//   public ModelAndView gettoaddress()
//	//   {
////		   ModelAndView mv=new ModelAndView("FormAddUserDetail");
////		   return mv;
//	//   }
//	   @RequestMapping("gotopayment")
//	   public ModelAndView gettopayment()
//	   {
//		   ModelAndView mv=new ModelAndView("payment");
//		   return mv;
//	   }
//	   @RequestMapping("tothankyou")
//	   public ModelAndView getthankyou()
//	   {
//		   ModelAndView mv=new ModelAndView("thankyou");
//		   return mv;
//	   }
//	   
//	   @RequestMapping("tousde")
//	   public ModelAndView getbacktouserdet(@ModelAttribute("userdetail") UserDao userdetail)
//	   {
//		   ModelAndView mv=new ModelAndView("FormAddUserDetail");
//		   mv.addObject("userdao", userdao);
//		   return mv;
//	   }
//	   
//	   @RequestMapping("toregistration")
//	   public ModelAndView gettoregistration()
//	   {
//		   ModelAndView mv=new ModelAndView("Registration");
//		   mv.addObject("reg",users);
//		   return mv;
//	   }
//	 
//	   @RequestMapping("Register")
//	   public String saveUser(@ModelAttribute("reg") Users users,final RedirectAttributes redirectAttributes)
//	   {
//			  ModelAndView mv = new ModelAndView();
//			  int count=0;
//			  System.out.println(users.getRole()+" "+users.getUsername());
//			  users.setRole("ROLE_USER");
//			  usersDao.saveOrUpdate(users);
//			  return "redirect:tousertable";
//	   }
//	   
//	  
//	  @RequestMapping("tousertable")
//	 public ModelAndView getAllUsers()
//	 {
//		  ModelAndView mv=new ModelAndView("UsersTable");
//		  List<Users> ulist=usersDao.getAllUsers();
//		  mv.addObject("uList",ulist);
//		  return mv;
//	 }
//	  @RequestMapping("edit.udo")
//	  public ModelAndView getEditUsers(@RequestParam(value="Id",required=true)int userId,final RedirectAttributes redirectAttributes)
//	  {
//		  System.out.println("userssssssssssssssss");
//		  users= usersDao.getByUsersId(userId);
//		  System.out.println("eeeee"+users.getUsername());
//		  ModelAndView mv=new ModelAndView("UserForm");
//		  mv.addObject("usr", users);
//		  return mv;
//		   
//	  }
//	  @RequestMapping("saveUser")
//	  public String savingUser(@ModelAttribute("usr") Users users,final RedirectAttributes redirectAttributes){
//		  ModelAndView mv = new ModelAndView();
//		  int count=0;
//		  System.out.println(users.getRole()+" "+users.getUsername());
//		  usersDao.saveOrUpdate(users);
//		  return "redirect:tousertable";
//	}
//	  
//	//  @RequestMapping("supplier/listig")
//	//  public ModelAndView getAllProduct()
//	//  {
////		   ModelAndView mv=new ModelAndView("TableProduct");
////		   List<Product> plist=productDao.getAllProduct();
////		   mv.addObject("pList", plist);
////		   return mv;
//	//  }
//		  @RequestMapping("userList")
//		  public ModelAndView getAllUserList(){
//			  ModelAndView mv =new ModelAndView("UsersTable");
//			  List<Users>ulist=usersDao.getAllUsers();
//			  mv.addObject("uList", ulist);
//			  return mv;
//		  }
//		  @RequestMapping("supplier/addProduct")
//			public ModelAndView addProducts(@ModelAttribute("prod")Product product)
//			{
//				
//				ModelAndView mv=new ModelAndView("FormAddProduct");
////				Product products=new Product(); 
//				mv.addObject("prod", product);
//				return mv;
//			}
//		  
//		  @RequestMapping("supplier/saveProduct")
//		  public String savingProduct(@ModelAttribute("prod") Product product,BindingResult result,HttpServletRequest request, final RedirectAttributes redirectAttributes)
//		  {
//			  ModelAndView mv=new ModelAndView();
//			  int count=0;
//			  System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmm One");
//			  System.out.println(product.getCategory()+""+product.getProductName());
//			  productDao.saveOrUpdate(product);
//			  System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmm One");
//			  MultipartFile itemimage=product.getImg();
//			  String rootdir = request.getSession().getServletContext().getRealPath("/");
//			  System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmm"+rootdir);
//			  Path path =Paths.get(rootdir+"resources/includes/im/"+product.getProductId()+".jpg");
////			  "resources/includes/im/"
//			  System.out.println("paaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//			  if(itemimage!=null && !itemimage.isEmpty()){
//				  System.out.println("rttttttttttttttttttttttttttttttttttttttt");
//				  try{
//					  System.out.println("ooooooooooooooooooooooooooooo"+path.toString());
//				  itemimage.transferTo(path.toFile());
//				  }
//				  catch(Exception e)
//				  {
//					  e.printStackTrace();
//					  throw new RuntimeException("product image saving failed",e);
//					  
//				  }
//			  }
//			return "redirect:listig";  
//		  }
//		  
//		  @RequestMapping("toustable")
//		  public ModelAndView getUsersTable()
//		  {
//			  ModelAndView mv=new ModelAndView("UsersTable");
//			  List<Users> ulist=usersDao.getAllUsers();
//			  mv.addObject("uList",ulist);
//			  return mv;
//		  }
//		  
//		 @RequestMapping("gotolanding")
//		 public ModelAndView gobacktolanding()
//		 {
//			 ModelAndView mv=new ModelAndView("LandingPage");
//		     return mv;
//		 }
//		  
//		  
//	  }
//
//
//
//	  }
//	
//
}
