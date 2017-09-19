package com.project.customerorderDAO;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.CartItemDAO.CartItemDAO;
import com.project.model.Cart;
import com.project.model.CartItem;
import com.project.model.Customer;
import com.project.model.CustomerOrder;


@Repository
public class CustomerOrderDAOimpl implements CustomerOrderDAO{
	@Autowired
private SessionFactory sessionFactory;
	@Autowired
	public CartItemDAO cartItemDAO;
	
	public CustomerOrder createOrder(Cart cart) {
		Session session=sessionFactory.getCurrentSession();
		
		List<CartItem> cartItems=cart.getCartItems();
		double grandTotal=0;
		for(CartItem cartItem:cartItems){
			grandTotal=cartItem.getTotalPrice()+grandTotal;
		}
		cart.setGrandTotal(grandTotal);
		Customer customer=cart.getCustomer();
		CustomerOrder customerOrder=new CustomerOrder();
		customerOrder.setPurchaseDate(new Date());
		customerOrder.setCart(cart);
		customerOrder.setCustomer(customer);
		customerOrder.setBillingAddress(customer.getBillingAddress());
		customerOrder.setShippingAddress(customer.getShippingAddress());
		session.save(customerOrder);//insert, also execute update queries for other tables
		return customerOrder;
	}
	

}
