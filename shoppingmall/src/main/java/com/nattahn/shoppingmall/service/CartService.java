package com.nattahn.shoppingmall.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nattahn.shoppingmall.model.UserModel;
import com.nattahn.shoppingmallbackend.dao.CartLineDAO;
import com.nattahn.shoppingmallbackend.dao.ProductDAO;
import com.nattahn.shoppingmallbackend.dto.Cart;
import com.nattahn.shoppingmallbackend.dto.CartLine;
import com.nattahn.shoppingmallbackend.dto.Product;

@Service("cartService")
public class CartService {
	
	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	ProductDAO productDAO;
	
	//returns the cart of the user who has logged in
	private Cart getCart() {
		
		return ((UserModel)session.getAttribute("userModel")).getCart();
		
	}
	
	
	
	//returns the entire cart lines
	public List<CartLine> getCartLines(){
		
		return cartLineDAO.list(this.getCart().getId());
	}

	public String manageCartLine(int cartLineId, int count) {
		
		//fetch the cart line 
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine == null) {
			return "result=error";
		}else {
			
			Product product = cartLine.getProduct();
			double oldTotal = cartLine.getTotal();
			
			//checking if the product is available
			if(product.getQuantity() < count) {
				return "result=unavailable";
			}
			
			
			//update total ,price and count of cartLine
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setTotal(product.getUnitPrice() * count);
			cartLineDAO.update(cartLine);
			
			//update GrandTotal of the Cart
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
			cartLineDAO.updateCart(cart);
			
			return "result=updated";
		}
		
	}

	public String deleteCart(int cartLineId) {
		//fetch the cartLine 
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine == null) {
			return "result=error";
		}else {
			//update the cart
			Cart cart = this.getCart();
			
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);
			cartLineDAO.updateCart(cart);
			
			//remove the cart line 
			cartLineDAO.delete(cartLine);
			
			return "result=deleted";
		}
		
		
		
		
	}

	public String addCartLine(int productId) {

		String response = null; 
		
		Cart cart = this.getCart();
		
		CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(),productId);
		
		if(cartLine == null) {
			
			//add a new CartLine 
			cartLine = new CartLine();
			
			//fetch the product 
			Product product = productDAO.get(productId);
			
			cartLine.setCartId(cart.getId());
			cartLine.setProduct(product);
			cartLine.setBuyingPrice(productId);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setProductCount(1);
			cartLine.setTotal(product.getUnitPrice());
			cartLine.setAvailable(true);
			
			cartLineDAO.add(cartLine);
			
			cart.setCartLines(cart.getCartLines() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
			
			cartLineDAO.updateCart(cart);
			
			response = "result=added";
			
			
		}else {
			//check if the cartLine has reached the maximum count
			if(cartLine.getProductCount() < 3) {
				//update the productCount for that cartLine 
				response = this.manageCartLine(cartLine.getId(), cartLine.getProductCount() + 1);
				
			}else {
				response = "result=maximum";
			}
		}
		
		return response;
	}
	
	
	public String validateCartLine() {
		Cart cart = this.getCart();
		List<CartLine> cartLines = cartLineDAO.list(cart.getId());
		double grandTotal = 0.0;
		int lineCount = 0;
		String response = "result=success";
		boolean changed = false;
		Product product = null;
		for(CartLine cartLine : cartLines) {					
			product = cartLine.getProduct();
			changed = false;
			// check if the product is active or not
			// if it is not active make the availability of cartLine as false
			if((!product.isActive() && product.getQuantity() == 0) && cartLine.isAvailable()) {
				cartLine.setAvailable(false);
				changed = true;
			}			
			// check if the cartLine is not available
			// check whether the product is active and has at least one quantity available
			if((product.isActive() && product.getQuantity() > 0) && !(cartLine.isAvailable())) {
					cartLine.setAvailable(true);
					changed = true;
			}
			
			// check if the buying price of product has been changed
			if(cartLine.getBuyingPrice() != product.getUnitPrice()) {
				// set the buying price to the new price
				cartLine.setBuyingPrice(product.getUnitPrice());
				// calculate and set the new total
				cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
				changed = true;				
			}
			
			// check if that much quantity of product is available or not
			if(cartLine.getProductCount() > product.getQuantity()) {
				cartLine.setProductCount(product.getQuantity());										
				cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
				changed = true;
				
			}
			
			// changes has happened
			if(changed) {				
				//update the cartLine
				cartLineDAO.update(cartLine);
				// set the result as modified
				response = "result=modified";
			}
			
			grandTotal += cartLine.getTotal();
			lineCount++;
		}
		
		cart.setCartLines(lineCount++);
		cart.setGrandTotal(grandTotal);
		cartLineDAO.updateCart(cart);

		return response;
	}	
	
}
