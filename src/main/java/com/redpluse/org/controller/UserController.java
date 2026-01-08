package com.redpluse.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redpluse.org.entity.User;
import com.redpluse.org.service.UserService;

@RestController
@RequestMapping("/Redpluse")
@CrossOrigin("http://localhost:5173/")
public class UserController {
	
	private final UserService service ;
	
	public UserController(UserService service)
	{
		this.service = service ;
	}
	
	@PostMapping("/register")
	public User register(@RequestParam User user)
	{
		return service.registerUser(user);
	}
	public List<User> getAllHelper()
	{
		return service.getallHelper();
	}
	public List<User> getHelperByBloodType(@PathVariable String bloodType)
	{
		return service.getHelpersByBloodType(bloodType);
	}
	
	
	
	
	

}
