package com.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.customerorderDAO.CustomerOrderDAO;
import com.project.model.Cart;
import com.project.model.CustomerOrder;

@Service
@Transactional
public class CustomerOrderServiceimpl implements CustomerOrderService{
	@Autowired
public CustomerOrderDAO customerOrderDAO;
	
	public CustomerOrder createOrder(Cart cart) {
		return customerOrderDAO.createOrder(cart);
	}
	
	
}

