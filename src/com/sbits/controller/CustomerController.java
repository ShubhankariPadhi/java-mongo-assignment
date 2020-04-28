package com.sbits.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sbits.model.Customer;
import com.sbits.service.CustomerService;

@Controller
@RequestMapping("/customer")

public class CustomerController {

	@Autowired 
	private CustomerService customerService;
		
	/*	@RequestMapping("/customerList")
		public String listCustomer(Model theModel) {
			return "ListCustomer";                   // list-customer is jsp page name
		}
	*/	
		
		@RequestMapping("/addCustomer")
		public String displayAddCustomerForm(Model model) {
			Customer customer=new Customer();
			model.addAttribute("customer", customer);
			return  "AddCustomer";
		}
		
		@RequestMapping("/saveProcess")
		public String saveProcess(@ModelAttribute ("customer")Customer customer,Model model) {
			
			customerService.saveCustomerObj(customer);
			List<Customer>	 listOfCustomers= customerService.getAllCustomers();
			model.addAttribute("theCustomers", listOfCustomers);
			return  "ListCustomer";
		}
		
		
		@RequestMapping("/customerList")
		public String getAllCustomers(Model model) {
		List<Customer>	 listOfCustomers= customerService.getAllCustomers();
		model.addAttribute("theCustomers", listOfCustomers);
		return "ListCustomer";
		}
		
    public Customer findById(Integer customerId) {
    	
    	Customer customer=customerService.getCustomerObjById(customerId);
    return  customer; 
    }
		
    @RequestMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("customerId")Integer customerId,Model model) {
    	
    	Customer customer=findById(customerId);
    	model.addAttribute("customer",customer);
    	return "AddCustomer";
    }
    
    @RequestMapping("/deleteRecord")
    public String deleteCustomerObj(@RequestParam("customerId")Integer customerId) {
    	Customer customer=findById(customerId);
    	customerService.deleteCustomerObj(customer);
    	return "redirect:/customer/customerList";
    }
    
    @RequestMapping("/customerSearch")
	public String customerSearch(@RequestParam("freeText")String freeText, Model model) {
	List<Customer>	 listOfCustomers= customerService.getSearchedCustomers(freeText);
	model.addAttribute("theCustomers", listOfCustomers);
	return "ListCustomer";
	}
}
