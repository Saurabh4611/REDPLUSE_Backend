package com.redpluse.org.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.redpluse.org.dao.UserDao;
import com.redpluse.org.entity.User;



@Service
public class UserService {
	
	private final UserDao dao ;
	
	public UserService (UserDao dao) {
		this.dao = dao ;
	}
	
	public User registerUser(User user)
	{
		if(dao.findByEmail(user.getEmail()) != null) {
			throw new RuntimeException("Email already exists");
		}
		return dao.save(user);
	}
	
	
	public List<User> getallHelper()
	{
		return dao.findByRole("HELPER");
	}
	
	public List<User> getHelpersByBloodType(String bloodType)
	{
		return dao.findByBloodType(bloodType);
	}
	
	
	
	
	

}
