package com.redpluse.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redpluse.org.entity.DonationEntity;

@Repository
public interface DonationEntityDao extends JpaRepository<DonationEntity, Long>{

}
