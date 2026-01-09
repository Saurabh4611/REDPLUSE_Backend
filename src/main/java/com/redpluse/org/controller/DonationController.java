package com.redpluse.org.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redpluse.org.entity.DonationEntity;
import com.redpluse.org.service.DonationEntityService;

@RestController
@RequestMapping("/Redpluse/donation")
@CrossOrigin("http://localhost:5173/")
public class DonationController {
	
	public final DonationEntityService service ;
	
	public DonationController(DonationEntityService service)
	{
		this.service = service ;
		
	}
	
	@PostMapping("/assign")
	public DonationEntity assignhelper(@RequestParam long requestid ,@RequestParam long helperid)
	{
		return service.assignHelper(requestid, helperid);
	}

}
