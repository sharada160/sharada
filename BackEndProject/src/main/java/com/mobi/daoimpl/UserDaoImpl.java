package com.mobi.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mobi.Model.Users;
import com.mobi.dao.UserDao;

public class UserDaoImpl  implements UserDao{
	@Autowired
	SessionFactory sessionFactory;
	public UserDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public int SaveOrUpdate(Users users) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(users);
		return 0;
	}

	@Transactional
	public List<Users> getAllUsers() {
		@SuppressWarnings("unchecked")
		List<Users> listUsers = (List<Users>) sessionFactory.getCurrentSession().createCriteria(Users.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return listUsers;
	}

	public Users getUsersBy(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public int deleteUserById(int userId) {
		Users users = new Users();
		users.setUserid(userId);
		sessionFactory.getCurrentSession().delete(users);

		return 0;
	}

}
