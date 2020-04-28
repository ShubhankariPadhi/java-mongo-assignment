package com.sbits.service;

import java.util.List;

import com.sbits.model.Customer;

public interface CustomerService {

	public void saveCustomerObj(Customer customer);

	public List<Customer> getAllCustomers();

	public Customer getCustomerObjById(Integer customerId);

	public void deleteCustomerObj(Customer customer);

	public List<Customer> getSearchedCustomers(String freeText);

}
