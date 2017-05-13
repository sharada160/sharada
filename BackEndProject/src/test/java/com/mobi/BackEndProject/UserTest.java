package com.mobi.BackEndProject;
	import java.util.List;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
	import org.springframework.util.SystemPropertyUtils;

import com.mobi.Model.Users;
import com.mobi.dao.UserDao;
	

	public class UserTest {

		public static void main(String[] args) {
			AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
			ctx.scan("com.mobi.*");
			ctx.refresh();
			System.out.println("Done");
			
			UserDao userDao=(UserDao) ctx.getBean("userDao");
			Users users=(Users) ctx.getBean("users");
////			
//			
		users.setUserid(5);
			users.setName("a");
			users.setPassword("abc");
			users.setRole("ROLE_ADMIN");
			userDao.SaveOrUpdate(users);

//			userDao.deleteUserById(2);
			
////			List<Users> lst=userDao.getAllUsers();
////			for(Users usr:lst){
////				System.out.println(usr.getUserid()+" "+usr.getName()+" "+usr.getPassword()+" "+usr.getRole());
//			}
		}
	}


