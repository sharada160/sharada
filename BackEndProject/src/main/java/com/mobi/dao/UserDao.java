package com.mobi.dao;

import java.util.List;

import com.mobi.Model.Users;


public interface UserDao {

	int SaveOrUpdate(Users users);
	List<Users>getAllUsers();
	Users getUsersBy(int userId);
	int deleteUserById(int usersId);

}
