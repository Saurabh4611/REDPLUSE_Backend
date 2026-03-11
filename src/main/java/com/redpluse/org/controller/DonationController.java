package com.redpluse.org.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.redpluse.org.entity.DonationEntity;
import com.redpluse.org.service.DonationEntityService;

@RestController
@RequestMapping("/Redpluse/donation")
@CrossOrigin(origins = {"https://redpluse.netlify.app/","https://redpluse.online/"})

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
	
	//http://localhost:8080/Redpluse/donation/helper/${helperId}
	@GetMapping("/helper/{helperId}")
	public List<DonationEntity> getDonationByHelper(@PathVariable Long helperId)
	{
	    return service.getDonationByHelper(helperId);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDonation(@PathVariable long id){
	    service.deleteDonation(id);
	    return ResponseEntity.ok("Deleted");
	}
	@GetMapping("/request/helper/{requestId}")
	public DonationEntity getHelper(@PathVariable Long requestId) {
	    return service.getHelper(requestId);
	}
	@GetMapping("/all")
	public List<DonationEntity> getAllDonations(){
	    return service.getAllDonations();
	}
	

}
