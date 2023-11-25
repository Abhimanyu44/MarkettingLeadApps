package com.markettingLeadApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.markettingLeadApp.Dto.LeadDto;
import com.markettingLeadApp.entity.Lead;
import com.markettingLeadApp.repository.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {
	
	@Autowired
	private LeadRepository leadRepo;
	
	@Override
	public void saveLead(Lead lead) {
		leadRepo.save(lead);

	}
	@Override
	public List<Lead> getLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public void deleteLead(long id) {
		leadRepo.deleteById(id);
		
	}
	
	@Override
	public Lead findLeadById(long id) {
		Optional<Lead> findbyId = leadRepo.findById(id);
		if(findbyId.isPresent()) {
			return findbyId.get();
		}
		return null;
	}
	
	@Override
	public void updateLead(LeadDto dto) {
		Lead lead = new Lead();
		lead.setId(dto.getId());
		lead.setFirstname(dto.getFirstname());
		lead.setLastname(dto.getLastname());
		lead.setEmail(dto.getEmail());
		lead.setMobile(dto.getMobile());
		
		leadRepo.save(lead);
	}

}
