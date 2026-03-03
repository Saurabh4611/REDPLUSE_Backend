package com.redpluse.org.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redpluse.org.entity.BloodRequest;
import com.redpluse.org.service.BloodRequestService;

@RestController
@RequestMapping("/Redpluse/request")
@CrossOrigin("http://localhost:5173/")
public class BloodRequestController {
	
	private final BloodRequestService service ;
	
	public BloodRequestController(BloodRequestService service)
	{
		this.service = service ;
	}
	
	@PostMapping("/create/{patientId}")
	public BloodRequest createRequest(@PathVariable long patientId , @RequestBody BloodRequest request)
	{
		return service.createRequest(patientId, request);
	}
	
	@GetMapping("/allrequests")
	public List<BloodRequest> getAllrequests()
	{
		return service.getAllRequests();
	}

}
