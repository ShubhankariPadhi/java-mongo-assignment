package com.sbits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbits.DAO.CustomerDAO;
import com.sbits.model.Customer;

@Service
public class CustomerServiceImpl  implements CustomerService{

	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public void saveCustomerObj(Customer customer) {
		customerDAO.saveCustomerObj(customer);
	}

	@Override
	@Transactional
	public List<Customer> getAllCustomers() {
	
		
		return customerDAO.getAllCustomers();
	}

	@Override
	@Transactional
	public Customer getCustomerObjById(Integer customerId) {
		 return customerDAO.getCustomerObjById(customerId);
		
	}

	@Override
	@Transactional
	public void deleteCustomerObj(Customer customer) {
		customerDAO.deleteCustomerObj(customer);
	}

	@Override
	@Transactional
	public List<Customer> getSearchedCustomers(String freeText) {
		return customerDAO.getSearchedCustomer(freeText);
	}

}
