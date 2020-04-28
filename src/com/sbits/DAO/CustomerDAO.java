package com.sbits.DAO;

import java.util.List;

import com.sbits.model.Customer;

public interface CustomerDAO {

	public void saveCustomerObj(Customer customer);

	public List<Customer> getAllCustomers();

	public Customer getCustomerObjById(Integer customerId);

	public void deleteCustomerObj(Customer customer);

	public List<Customer> getSearchedCustomer(String freeText);

}
