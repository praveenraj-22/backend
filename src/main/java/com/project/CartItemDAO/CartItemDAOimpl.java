package com.project.CartItemDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.Cart;
import com.project.model.CartItem;

@Repository("cartItemDAO")
public class CartItemDAOimpl implements CartItemDAO {
	public CartItemDAOimpl() {
		System.out.println("cart item dao impl is created");
	}

	@Autowired

	public SessionFactory sessionFactory;

	
	public void addCartItem(CartItem cartItem) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
		
	}

	
	public void deleteCartItem(int cartItemId) {
		Session session=sessionFactory.getCurrentSession();
		
		CartItem cartItem=(CartItem)session.get(CartItem.class, cartItemId);
		session.delete(cartItem);
		
		
	}


	public void deleteAllCartItem(int cartId) {
		Session session=sessionFactory.getCurrentSession();
		Cart cart=(Cart)session.get(Cart.class, cartId);
		List<CartItem> cartItems=cart.getCartItems();
		for
		
			(CartItem cartItem:cartItems)
		{
			session.delete(cartItem);
		}	
	}


	
	public Cart getCart(int cartId) {
		Session session=sessionFactory.getCurrentSession();
		Cart cart=(Cart)session.get(Cart.class, cartId);
		return cart;
	}

	
}
