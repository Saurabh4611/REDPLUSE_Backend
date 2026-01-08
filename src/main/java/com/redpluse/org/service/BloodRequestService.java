package com.redpluse.org.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.redpluse.org.dao.BloodRequestDao;
import com.redpluse.org.dao.UserDao;
import com.redpluse.org.entity.BloodRequest;
import com.redpluse.org.entity.User;

@Service
public class BloodRequestService {
	
	private final BloodRequestDao bloodrepo ;
	private final UserDao dao ;
	
	//constructor injection because of immutablity and more testablity
	public BloodRequestService(BloodRequestDao bloodrepo, UserDao dao)
	{
		this.bloodrepo = bloodrepo ;
		this.dao = dao ;
		
	}
	
	public BloodRequest createRequest(long patientId ,BloodRequest request)
	{
		User patient = dao.findById(patientId).orElseThrow();
		request.setPatient(patient);
		request.setStatus("PENDING");
		
		return bloodrepo.save(request);
	}
	public List<BloodRequest> getAllRequests()
	{
		return bloodrepo.findAll();
	}

}
