package com.nattahn.shoppingmallbackend.dao;

import java.util.List;

import com.nattahn.shoppingmallbackend.dto.Address;
import com.nattahn.shoppingmallbackend.dto.Cart;
import com.nattahn.shoppingmallbackend.dto.User;

public interface UserDAO {	
	//add an user
	boolean addUser(User user);
	
	User getByEmail(String email);
	
	//add an address
	boolean addAddress(Address address);
	
	//alternative
	Address getBillingAddress(int userId);
	List<Address> listShippingAddresses(int userId);
	
//	Address getBillingAddress(User user);
//	List<Address> listShippingAddresses(User user);
	
	//add a cart 
	boolean updateCart(Cart cart);
}
