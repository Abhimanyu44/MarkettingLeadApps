package com.markettingLeadApp.service;

import java.util.List;

import com.markettingLeadApp.Dto.LeadDto;
import com.markettingLeadApp.entity.Lead;


public interface LeadService {

	public void saveLead(Lead lead);

	public List<Lead> getLeads();

	void deleteLead(long id);

	public Lead findLeadById(long id);
	
	public void updateLead(LeadDto dto);

}



