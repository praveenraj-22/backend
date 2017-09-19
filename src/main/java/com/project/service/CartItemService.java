package com.project.service;

import com.project.model.Cart;
import com.project.model.CartItem;

public interface CartItemService {
	void addCartItem(CartItem cartItem);

	void deleteCartItem(int cartitemId);

	void deleteAllCartItems(int cartId);

	Cart getCart(int cartId);
}
