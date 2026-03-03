package com.redpluse.org.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redpluse.org.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email) ;
	
	List<User> findByRole(String role);
	
	List<User> findByBloodType(String bloodType);
	
}
