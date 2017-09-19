package com.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.CustomerDAO.CustomerDAO;
import com.project.model.Customer;
import com.project.model.User;
@Service
@Transactional

public class CustomerServiceimpl implements CustomerService
{
@Autowired
	public CustomerDAO customerDAO;
	
	public void registerCustomer(Customer customer) {
		customerDAO.registerCustomer(customer);
		
		
	}

	public User validateUsername(String username) {
		
		return customerDAO.validateUsername(username);
	}


	public Customer validateEmail(String email) {
	
		return customerDAO.validateEmail(email);
	}

	public Customer getCustomerByUsername(String username) {

		return customerDAO.getCustomerByUsername(username);
	}

}
