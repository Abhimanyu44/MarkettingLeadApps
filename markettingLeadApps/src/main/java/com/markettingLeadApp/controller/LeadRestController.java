package com.markettingLeadApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.markettingLeadApp.Dto.LeadDto;
import com.markettingLeadApp.entity.Lead;
import com.markettingLeadApp.mail.EmailService;
import com.markettingLeadApp.repository.LeadRepository;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {

	@Autowired
	private LeadRepository leadRepo;
//	@Autowired
//	private EmailService emailService;

// <-----------------------------------List M1------------------------------------------------------------->   //

	// http://localhost:8080/api/leads //
	@GetMapping
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

// <-----------------------------------List M2------------------------------------------------------------->   //

	// http://localhost:8080/api/leads //
//	@GetMapping
//	public List<Lead> getAllLeads1() {
//		List<Lead> leads = leadRepo.findAll();
//		return leads;
//	}
	
// <--------------------------------------Save M1---------------------------------------------------------->	//

//	@PostMapping
//	public void saveLead(@RequestBody Lead lead) {
//		leadRepo.save(lead);
//		
//	}

// <--------------------------------------Save M2---------------------------------------------------------->	//

	@PostMapping
	public ResponseEntity<Lead> saveLead1(@RequestBody Lead lead) {
		Lead lead1 = leadRepo.save(lead);
		//emailService.sendSimpleMail(lead.getEmail(), "Test", "Testing on the way!!");
		return new ResponseEntity<>(lead1, HttpStatus.CREATED);

	}
// <-------------------------------------Update M1----------------------------------------------------------->   //

//  http://localhost:8080/api/leads?id=1  //  Query Parameter
//	@PutMapping
//	public void updateLead(@RequestParam("id") long id, @RequestBody LeadDto Dto)
//	{
//		Optional<Lead> findById= leadRepo.findById(id);
//		
//		Lead lead = findById.get();
//		lead.setFirstname(Dto.getFirstname());
//		lead.setLastname(Dto.getLastname());
//		lead.setEmail(Dto.getEmail());
//		lead.setMobile(Dto.getMobile());
//		leadRepo.save(lead);
//	}

// <------------------------------------Update M2------------------------------------------------------------>   //

//	http://localhost:8080/api/leads?id=1
//	@PutMapping("/{id}")
//	public void updateLead1(@PathVariable long id, @RequestBody Lead lead){
//		Optional<Lead> findById= leadRepo.findById(id);
//		
//		if (findById.isPresent()) {
//		Lead lead1 = findById.get();
//		lead1.setFirstname(lead.getFirstname());
//		lead1.setLastname(lead.getLastname());
//		lead1.setEmail(lead.getEmail());
//		lead1.setMobile(lead.getMobile());
//		
//		 leadRepo.save(lead1);
//			
//		}
//	}

// <------------------------------------Update M3------------------------------------------------------------>   //

//	http://localhost:8080/api/leads?id=1
//	@PutMapping
//	public ResponseEntity<Lead> updateLead2(@RequestParam("id") long id, @RequestBody LeadDto dto) {
//		Optional<Lead> findById = leadRepo.findById(id);
//
//		Lead lead = findById.get();
//		lead.setFirstname(dto.getFirstname());
//		lead.setLastname(dto.getLastname());
//		lead.setEmail(dto.getEmail());
//		lead.setMobile(dto.getMobile());
//
//		Lead updatedlead = leadRepo.save(lead);
//		return new ResponseEntity<>(updatedlead, HttpStatus.OK);
//	}

// <------------------------------------Update M3------------------------------------------------------------> //

//		http://localhost:8080/api/leads?id=1
	@PutMapping
	public ResponseEntity<Lead> updateLead3(@RequestParam("id") long id, @RequestBody Lead lead) {
		Optional<Lead> findById = leadRepo.findById(id);

		if (findById.isPresent()) {
			Lead lead1 = findById.get();
			lead1.setFirstname(lead.getFirstname());
			lead1.setLastname(lead.getLastname());
			lead1.setEmail(lead.getEmail());
			lead1.setMobile(lead.getMobile());

			Lead updatedlead = leadRepo.save(lead1);
			return new ResponseEntity<>(updatedlead, HttpStatus.OK);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

// <-----------------------------Delete M1------------------------------------------------------------------->   //

//  http://localhost:8080/api/leads?id=1
//  Query Parameter
	
//	@DeleteMapping
//	public void deleteLead(@RequestParam("id") long id) {
//		  leadRepo.deleteById(id);

//		List<Lead> leads = leadRepo.getById(id);

//	}
	
// <--------------------------------Delete M2---------------------------------------------------------------->   //

//  http://localhost:8080/api/leads/1
//  Path Parameter
//	@DeleteMapping("/{id}")
//	public void deleteLead1(@PathVariable("id") long id) {
//		  leadRepo.deleteById(id);

//	}

//	<--------------------------------Delete M3---------------------------------------------------------------->   //

//  http://localhost:8080/api/leads/1
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteLead2(@PathVariable("id") long id) {
		leadRepo.deleteById(id);

//	    return new ResponseEntity<>("Delete successfully", HttpStatus.OK);
	    return ResponseEntity.ok("Record Deleted successfully");
		
	}
}

//	<--------------------------------Delete M4---------------------------------------------------------------->   //

//  http://localhost:8080/api/leads?id=1
//	@DeleteMapping
//	public ResponseEntity<String> deleteLead3(@RequestParam("id") long id) {
//		leadRepo.deleteById(id);
//
//		return ResponseEntity.ok("Record Deleted successfully");
//	}
//}
