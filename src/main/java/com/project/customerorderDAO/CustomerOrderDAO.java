package com.project.customerorderDAO;

import com.project.model.Cart;
import com.project.model.CustomerOrder;

public interface CustomerOrderDAO {
CustomerOrder createOrder(Cart cart);

}
