package com.nattahn.shoppingmallbackend.dao;

import java.util.List;

import com.nattahn.shoppingmallbackend.dto.Cart;
import com.nattahn.shoppingmallbackend.dto.CartLine;
import com.nattahn.shoppingmallbackend.dto.OrderDetail;


public interface CartLineDAO {
	
	// the common methods from previously coded one 
	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);
	public boolean remove(CartLine cartLine);
	
	//other business method related to the cart lines;
	
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId , int productId);
	
	//add a cart 
	boolean updateCart(Cart cart);
	
	// adding order details
	boolean addOrderDetail(OrderDetail orderDetail);
}
