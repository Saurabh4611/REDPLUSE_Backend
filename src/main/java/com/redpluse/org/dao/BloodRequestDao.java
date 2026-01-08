package com.redpluse.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redpluse.org.entity.BloodRequest;

@Repository
public interface BloodRequestDao  extends JpaRepository<BloodRequest, Long>{

	
}
