package com.mobi.BackEndProject;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
import com.mobi.daoimpl.CartDaoImpl;
import com.mobi.daoimpl.CategoryDaoImpl;
import com.mobi.daoimpl.ProductDaoImpl;
import com.mobi.daoimpl.ShippingDaoImpl;
import com.mobi.daoimpl.UserDaoImpl;


@EnableTransactionManagement
@Configuration
@ComponentScan("com.niit.*")
public class App 
{
    
	 @Bean(name = "dataSource")
	    public DataSource getDataSource() {
	    	BasicDataSource dataSource = new BasicDataSource();
	    	dataSource.setDriverClassName("org.h2.Driver");
	    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/shopping");
	    	dataSource.setUsername("mm");
	    	dataSource.setPassword("ss");
	    	
	    	return dataSource;
	    }
	    
	  private Properties getHibernateProperties() {
	    	Properties properties = new Properties();
	    	properties.put("hibernate.show_sql", "true");
	    	properties.put("hibernate.format_sql", "true");
	    	properties.put("hibernate.hbm2ddl.auto", "update");
	    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	    	return properties;
	    }

@Autowired
@Bean(name = "sessionFactory")
public SessionFactory getSessionFactory(DataSource dataSource) {
	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	sessionBuilder.addProperties(getHibernateProperties());
	sessionBuilder.addAnnotatedClasses(Users.class);
	sessionBuilder.addAnnotatedClasses(Shipping.class);
	sessionBuilder.addAnnotatedClasses(Product.class);
	sessionBuilder.addAnnotatedClasses(Category.class);
	sessionBuilder.addAnnotatedClasses(Cart.class);
	return sessionBuilder.buildSessionFactory();
}

@Autowired
@Bean(name = "transactionManager")
public HibernateTransactionManager getTransactionManager(
		SessionFactory sessionFactory) {
	HibernateTransactionManager transactionManager = new HibernateTransactionManager(
			sessionFactory);

	return transactionManager;
}

@Autowired
@Bean(name="userDao")
public UserDao getUsersDao(SessionFactory sessionFactory)
{
	return new UserDaoImpl(sessionFactory);
}
@Autowired
@Bean(name="users")
public Users getUsers()
{
	return new Users();
}

@Autowired
@Bean(name="shippingDao")
public ShippingDao getUserDetailDao(SessionFactory sessionFactory)
{
	return new ShippingDaoImpl(sessionFactory);
}
@Autowired
@Bean(name="shipping")
public Shipping getShipping()
{
	return new Shipping();
}

@Autowired
@Bean(name="productDao")
public ProductDao getProductDao(SessionFactory sessionFactory)
{
	return new ProductDaoImpl(sessionFactory);
}
@Autowired
@Bean(name="product")
public Product getProduct()
{
	return new Product();
}

@Autowired
@Bean(name="categoryDao")
public CategoryDao getCategoryDao(SessionFactory sessionFactory)
{
	return new CategoryDaoImpl(sessionFactory);
}
@Autowired
@Bean(name="category")
public Category getCategory()
{
	return new Category();
}

@Autowired
@Bean(name="cartDao")
public CartDao getCartDao(SessionFactory sessionFactory)
{
	return new CartDaoImpl(sessionFactory);
}
@Autowired
@Bean(name="cart")
public Cart getCart()
{
	return new Cart();
}
}