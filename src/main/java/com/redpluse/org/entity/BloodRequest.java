package com.redpluse.org.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "blood_requests")
public class BloodRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	private String requiredBloodType ;
	private int quantity ;
	private String status ;
	
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private User patient ;


	public BloodRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BloodRequest(long id, String requiredBloodType, int quantity, String status, User patient) {
		super();
		this.id = id;
		this.requiredBloodType = requiredBloodType;
		this.quantity = quantity;
		this.status = status;
		this.patient = patient;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getRequiredBloodType() {
		return requiredBloodType;
	}


	public void setRequiredBloodType(String requiredBloodType) {
		this.requiredBloodType = requiredBloodType;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public User getPatient() {
		return patient;
	}


	public void setPatient(User patient) {
		this.patient = patient;
	}


	@Override
	public String toString() {
		return "BloodRequest [id=" + id + ", requiredBloodType=" + requiredBloodType + ", quantity=" + quantity
				+ ", status=" + status + ", patient=" + patient + "]";
	}
	
	
	
	
}
