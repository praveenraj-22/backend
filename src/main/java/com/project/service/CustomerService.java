package com.project.service;

import com.project.model.Customer;
import com.project.model.User;

public interface CustomerService {

	void registerCustomer(Customer customer);

	User validateUsername(String username);

	Customer validateEmail(String email);

	Customer getCustomerByUsername(String username);

}
