package com.markettingLeadApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.markettingLeadApp.Dto.LeadDto;
import com.markettingLeadApp.entity.Lead;
import com.markettingLeadApp.mail.EmailService;
import com.markettingLeadApp.service.LeadService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LeadController {

	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailService emailService;

// <-----------------------------------Handler Methods------------------------------------------------------------->   //
	
//    http://localhost:8080/viewLeadForm

	@RequestMapping("viewLeadForm") // this annotation is used as a @WebServlet in spring boot
	public String viewLeadForm() {
		return "createLead";      // return to the createLead.jsp view page
	}                             // return keyword used as a RD in spring boot

// <-----------------------------------Save M1 (@ModelAttribute)------------------------------------------------------------->   //
                                          //  Method 1  //
	// http://localhost:8080/viewLeadForm
	
	@RequestMapping("/saveLead")
	public String saveLeadInformation(@ModelAttribute Lead lead, Model model) {
		// @ModelAttribute is used(helps) to read(copy) data from view page and
		// paste(store) into the entity class obj. lead 
		
		leadService.saveLead(lead);
		// System.out.println(lead.getEmail());
		emailService.sendSimpleMail(lead.getEmail(), "Test", "Testing on the way!!");
		System.out.println(lead.getEmail());
		model.addAttribute("msg", "Record is saved!!");
		return "createLead";
	}

// <-----------------------------------Save M2 Entity_Copy(DTO Class)------------------------------------------------------------->   //
	                                        //  Method 2  //
	// http://localhost:8080/viewLeadForm
		
//	@RequestMapping("/saveLead")
//	public String saveLeadInformation(LeadDto leadDto, Model model) {
//
//		Lead lead = new Lead();
//		lead.setFirstname(leadDto.getFirstname());
//		lead.setLastname(leadDto.getLastname());
//		lead.setEmail(leadDto.getEmail());
//		lead.setMobile(leadDto.getMobile());
//
//		leadService.saveLead(lead);
//		//emailService.sendMail(leadDto.getEmail(), "Test", "Testing on the way!!");
//		model.addAttribute("msg", "Record is saved!!");
//		return "createLead";
//	}

// <-----------------------------------Save M3 (@RequestParam())------------------------------------------------------------->   //
	                                           // Method 3  //
//	@RequestMapping("/saveLead")
//	public String saveLeadInformation(@RequestParam("firstName") String firstName,
//			@RequestParam("lastName") String lastName, @RequestParam("email") String email,
//			@RequestParam("mobile") long mobile, Model model) {
//
//		Lead lead = new Lead();
//		lead.setFirstname(firstName);
//		lead.setLastname(lastName);
//		lead.setEmail(email);
//		lead.setMobile(mobile);
//
//		leadService.saveLead(lead);
//		//emailService.sendMail(lead.getEmail(), "Test", "Testing on the way!!");
//		model.addAttribute("msg", "Record is saved!!");
//		return "createLead";
//	}

// <-----------------------------------List------------------------------------------------------------->   //
	// http://localhost:8080/list_leads
	
	@RequestMapping("/lists")
	public String getAllLeads(ModelMap model) {
		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	
// <-----------------------------------Delete------------------------------------------------------------->   //
	
	@RequestMapping("/delete")
	public String deleteLead(@RequestParam("id") long id, Model model) {
		leadService.deleteLead(id);

		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}

// <-----------------------------------ViewUpdate------------------------------------------------------------->   //
	
	@RequestMapping("/update")
	public String viewUpdateForm(@RequestParam("id") long id, Model model) {
		Lead lead = leadService.findLeadById(id);
		model.addAttribute("lead", lead);
		return "updateLead";

	}

// <-----------------------------------LeadUpdate------------------------------------------------------------->   //
	
	@RequestMapping("/updateLead")
	public String updateLead(LeadDto dto, Model model) {
		leadService.updateLead(dto);

		List<Lead> leads = leadService.getLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}
}
