package com.project.CartItemDAO;


import com.project.model.Cart;
import com.project.model.CartItem;

public interface CartItemDAO {
	void addCartItem(CartItem cartItem);

	void deleteCartItem(int cartItemId);

	public void deleteAllCartItem(int cartId);

	public Cart getCart(int cartId);

	

}
