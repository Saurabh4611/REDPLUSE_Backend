package com.redpluse.org.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "donations")
public class DonationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id ;	
	
	@OneToOne
	@JoinColumn(name = "blood_request_id")
	private BloodRequest bloodRequest ;
	
	@ManyToOne
	@JoinColumn(name = "helper_id")
	private User helper ;

	public DonationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DonationEntity(long id, BloodRequest bloodRequest, User helper) {
		super();
		this.id = id;
		this.bloodRequest = bloodRequest;
		this.helper = helper;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BloodRequest getBloodRequest() {
		return bloodRequest;
	}

	public void setBloodRequest(BloodRequest bloodRequest) {
		this.bloodRequest = bloodRequest;
	}

	public User getHelper() {
		return helper;
	}

	public void setHelper(User helper) {
		this.helper = helper;
	}

	@Override
	public String toString() {
		return "DonationEntity [id=" + id + ", bloodRequest=" + bloodRequest + ", helper=" + helper + "]";
	}
	
	
	

}
