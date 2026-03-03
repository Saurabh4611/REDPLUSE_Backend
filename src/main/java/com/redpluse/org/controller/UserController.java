package com.redpluse.org.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.redpluse.org.entity.User;
import com.redpluse.org.service.UserService;

@RestController
@RequestMapping("/Redpluse/users")
@CrossOrigin("http://localhost:5173/")
public class UserController {
	
	private final UserService service ;
	
	public UserController(UserService service)
	{
		this.service = service ;
	}
	
	@PostMapping("/register")
	public User register(@RequestBody User user)
	{
		return service.registerUser(user);
	}
	@GetMapping("/helpers")
	public List<User> getAllHelper()
	{
		return service.getallHelper();
	}
	@GetMapping("/helpers/{bloodType}")
	public List<User> getHelperByBloodType(@PathVariable String bloodType)
	{
		return service.getHelpersByBloodType(bloodType);
	}
	
	@PutMapping("/update/{id}")
    public User updateUser(
            @PathVariable Long id,
            @RequestBody User user) {

        return service.updateUser(id, user);
    }
	

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User request) {

	    System.out.println("EMAIL RECEIVED: " + request.getEmail());

	    User user = service.login(
	            request.getEmail(),
	            request.getPassword()
	    );

	    return ResponseEntity.ok(user);
	}
	
	
	
	

}
