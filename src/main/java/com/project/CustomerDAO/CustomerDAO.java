
package com.project.CustomerDAO;

import com.project.model.Customer;
import com.project.model.User;

public interface CustomerDAO {
	void registerCustomer(Customer customer);

	User validateUsername(String username);

	Customer validateEmail(String email);

	Customer getCustomerByUsername(String username);

}
