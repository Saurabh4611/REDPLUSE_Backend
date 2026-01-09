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
		
		return dao.save(user);
	}
	
	
	public List<User> getallHelper()
	{
		return dao.findByRole("HELPERS");
	}
	
	public List<User> getHelpersByBloodType(String bloodType)
	{
		return dao.findByBloodType(bloodType);
	}
	
	
	 public User updateUser(Long userId, User updatedUser) {

	        User existingUser = dao.findById(userId)
	                .orElseThrow(() -> new RuntimeException("User not found"));

	        
	        existingUser.setName(updatedUser.getName());
	        existingUser.setBloodType(updatedUser.getBloodType());
	        existingUser.setPhone(updatedUser.getPhone());
	        existingUser.setRole(updatedUser.getRole());
	        
	       

	        return dao.save(existingUser);
	    }
	 
	 public User login(String email, String password) {

	        User user = dao.findByEmail(email)
	                .orElseThrow(() -> new RuntimeException("User not found"));

	        if (!user.getPassword().equals(password)) {
	            throw new RuntimeException("Invalid password");
	        }

	        return user;
	    }
	 
	
	

	
	
	
	
	

}
