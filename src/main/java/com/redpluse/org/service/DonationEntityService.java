package com.redpluse.org.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.redpluse.org.dao.BloodRequestDao;
import com.redpluse.org.dao.DonationEntityDao;
import com.redpluse.org.dao.UserDao;
import com.redpluse.org.entity.BloodRequest;
import com.redpluse.org.entity.DonationEntity;
import com.redpluse.org.entity.User;

@Service
public class DonationEntityService {
	
	private final  UserDao dao ;
	private final  BloodRequestDao bloodrepo;
	private final  DonationEntityDao donaterepo;
	
	public DonationEntityService(UserDao dao ,BloodRequestDao bloodrepo,DonationEntityDao donaterepo)
	{
		this.dao = dao ;
		this.bloodrepo = bloodrepo ;
		this.donaterepo = donaterepo ;
		
	}
	
	public DonationEntity assignHelper(Long requestId , Long helperId)
	{
		BloodRequest request = bloodrepo.findById(requestId).orElseThrow();
	    User helper = dao.findById(helperId).orElseThrow();
		request.setStatus("ASSIGNED");
	    
	    DonationEntity donate = new DonationEntity();
	    donate.setBloodRequest(request);
	    donate.setHelper(helper);
	    
	    return donaterepo.save(donate);
	}

	public DonationEntity helperDonation(long id) {
		
		return donaterepo.findById(id).orElseThrow();
		
	}
	
	public List<DonationEntity> getDonationByHelper(Long helperId)
	{
	    return donaterepo.findByHelperId(helperId);
	}
	public void deleteDonation(long id) {
		donaterepo.deleteById(id);
	}
	
public DonationEntity getHelper(Long requestId) {
		
		return donaterepo.findById(requestId).orElseThrow();
	}
public List<DonationEntity> getAllDonations(){
    return donaterepo.findAll();
}
	
	

}
