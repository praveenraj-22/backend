package com.project.CustomerDAO;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.Authorities;
import com.project.model.Cart;
import com.project.model.Customer;
import com.project.model.User;

@Repository("customerDAO")
public class CustomerDAOimpl implements CustomerDAO {
	
	@Autowired

	public SessionFactory sessionFactory;

	public void registerCustomer(Customer customer) {
		User user = customer.getUser();
		user.setEnabled(true);
		String username = customer.getUser().getUsername();

		Authorities authorities = new Authorities();
		authorities.setRole("ROLE_USER");
		authorities.setUsername(username);
		Session session = sessionFactory.getCurrentSession();
		session.save(authorities);

		Cart cart = new Cart();
		cart.setCustomer(customer);
		customer.setCart(cart);
		session.save(customer);

	}

	
	public User validateUsername(String username) {
		
		
		
		return sessionFactory.getCurrentSession().createQuery("from User where username=?",User.class).setString(0, username).uniqueResult(); 
	}

	
	public Customer validateEmail(String email) {
		
		
		return sessionFactory.getCurrentSession().createQuery("from Customer where email=?",Customer.class).setString(0, email).uniqueResult();
	}


	
	public Customer getCustomerByUsername(String username) {
		User user = sessionFactory.getCurrentSession()
				.createQuery("FROM User WHERE Username = '" + username + "'", User.class).getSingleResult();
		System.out.println("User : "+user.getUsername());
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Customer WHERE USER_ID = '" + user.getId()+ "'", Customer.class).getSingleResult();
	}
}
