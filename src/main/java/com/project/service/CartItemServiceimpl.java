package com.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.CartItemDAO.CartItemDAO;
import com.project.model.Cart;
import com.project.model.CartItem;
@Service
@Transactional

public class CartItemServiceimpl implements CartItemService {

	@Autowired
	public CartItemDAO cartItemDAO;

	
	public void addCartItem(CartItem cartItem) {
	cartItemDAO.addCartItem(cartItem);	
	}

	
	public void deleteCartItem(int cartItemId) {
		cartItemDAO.deleteCartItem(cartItemId);
	}

	
	public void deleteAllCartItems(int cartId) {
		cartItemDAO.deleteAllCartItem(cartId);
	}


	public Cart getCart(int cartId) {
		return cartItemDAO.getCart(cartId);
	}
	


}
