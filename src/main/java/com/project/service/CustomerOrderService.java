package com.project.service;

import com.project.model.Cart;
import com.project.model.CustomerOrder;

public interface CustomerOrderService {
		CustomerOrder createOrder(Cart cart);
		}

