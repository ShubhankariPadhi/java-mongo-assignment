package com.sbits.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sbits.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveCustomerObj(Customer customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return sessionFactory.getCurrentSession().createQuery("from Customer").list();
	}

	
	@Override
	public Customer getCustomerObjById(Integer customerId) {
	Customer customer=(Customer) sessionFactory.getCurrentSession().get(Customer.class,customerId);
	return customer;
	}

	@Override
	public void deleteCustomerObj(Customer customer) {
	sessionFactory.getCurrentSession().delete(customer);
		
	}

	@Override
	public List<Customer> getSearchedCustomer(String freeText) {
		return sessionFactory.getCurrentSession().createQuery("from Customer where first_name LIKE '%"+freeText+"%' OR last_name LIKE '%"+freeText+"%' OR email LIKE '%"+freeText+"%'  order by first_name asc ").list(); 
				
	}

}
