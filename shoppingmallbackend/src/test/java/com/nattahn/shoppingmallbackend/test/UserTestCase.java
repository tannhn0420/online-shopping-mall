package com.nattahn.shoppingmallbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nattahn.shoppingmallbackend.dao.UserDAO;
import com.nattahn.shoppingmallbackend.dto.Address;
import com.nattahn.shoppingmallbackend.dto.Cart;
import com.nattahn.shoppingmallbackend.dto.User;

public class UserTestCase {
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null; 
	private Cart cart = null;
	private Address address = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.nattahn.shoppingmallbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
		
	}
	
//	@Test
//	public void testAdd() {
//		
//		user = new User();
//		user.setFirstName("Nhat");
//		user.setLastName("Tan");
//		user.setEmail("tannhn0420@gmail.com");
//		user.setContactNumber("0366335835");
//		user.setRole("USER");
//		user.setPassword("123456");
//		
//		
//		//add the user 
//		assertEquals("Failed to add user", true, userDAO.addUser(user));
//		
//		
//		address = new Address();
//		address.setAddressLineOne("357/3a1 Kha Van Can , P.Hiep Binh Chanh,Thu Duc");
//		address.setAddressLineTwo("Nha Tho Trieu Phong , Ninh Thuan");
//		address.setCity("Tp HCM");
//		address.setState("HCM City");
//		address.setCountry("Vietnam");
//		address.setPostalCode("10000");
//		address.setBilling(true);
//		
//		//link the user with the address using user id
//		address.setUserId(user.getId());
//		
//		//add the address FOR USER
//		assertEquals("Failed to add address!",true,userDAO.addAddress(address));
//		
//		
//		//ADD CART FOR USER
//		if(user.getRole().equals("USER")) {
//			//create a cart for this user
//			cart = new Cart();
//			cart.setUser(user);
//			
//			//add the cart for user
//			assertEquals("Failed to add cart!",true,userDAO.addCart(cart));
//			
//			//add a shipping address for this user
//			address = new Address();
//			address.setAddressLineOne("357/6 Kha Van Can , P.Hiep Binh Chanh,Thu Duc");
//			address.setAddressLineTwo("Trieu Phong , Ninh Thuan");
//			address.setCity("Tp HCM");
//			address.setState("HCM City");
//			address.setCountry("Vietnam");
//			address.setPostalCode("10000");
//			
//			//set shipping to true
//			address.setShipping(true);
//			
//			
//			//link it with the user
//			address.setUserId(user.getId());
//			
//			//add the shipping address
//			assertEquals("Failed to add shipping address!",true,userDAO.addAddress(address));
//			
//		}
//		
//		
//		
//		
//		
//	}
	
	
	
//	@Test
//	public void testAdd() {
//		
//		user = new User();
//		user.setFirstName("Nhat");
//		user.setLastName("Tan");
//		user.setEmail("tannhn0420@gmail.com");
//		user.setContactNumber("0366335835");
//		user.setRole("USER");
//		user.setPassword("123456");
//
//		//ADD CART FOR USER
//		if(user.getRole().equals("USER")) {
//			//create a cart for this user
//			cart = new Cart();
//			cart.setUser(user);
//			
//			// attach cart with the user
//			user.setCart(cart);
//		}
//		
//		//add the user 
//		assertEquals("Failed to add user", true, userDAO.addUser(user));
//
//		
//	}
	
	
//	@Test
//	public void testUpdateCart() {
//		
//		//fetch the user by its email 
//		user = userDAO.getByEmail("tannhn0420@gmail.com");
//		
//		//get the cart of the user 
//		cart = user.getCart();
//		
//		cart.setGrandTotal(5555);
//		cart.setCartLines(2);
//		
//		assertEquals("Failed to update the cart!",true,userDAO.updateCart(cart));
//	}
	
	
//	@Test
//	public void testAddAddress() {
//		// add an user
//		user = new User();
//		user.setFirstName("Nhat");
//		user.setLastName("Tan");
//		user.setEmail("tannhn0420@gmail.com");
//		user.setContactNumber("0366335835");
//		user.setRole("USER");
//		user.setPassword("123456");
//		
//		
//		//add the user 
//		assertEquals("Failed to add user", true, userDAO.addUser(user));
//		
//		//add the address
//		
//		address = new Address();
//		address.setAddressLineOne("357/3a1 Kha Van Can , P.Hiep Binh Chanh,Thu Duc");
//		address.setAddressLineTwo("Nha Tho Trieu Phong , Ninh Thuan");
//		address.setCity("Tp HCM");
//		address.setState("HCM City");
//		address.setCountry("Vietnam");
//		address.setPostalCode("10000");
//		address.setBilling(true);
//		
//		
//		
//		//attached the user to the address
//		address.setUser(user);
//		
//		assertEquals("Failed to add address!" ,true , userDAO.addAddress(address));
//		
//		
//		
//		//add shipping address 
//		address = new Address();
//		address.setAddressLineOne("357/3a1 Kha Van Can , P.Hiep Binh Chanh,Thu Duc");
//		address.setAddressLineTwo("Nha Tho Trieu Phong , Ninh Thuan");
//		address.setCity("Tp HCM");
//		address.setState("HCM City");
//		address.setCountry("Vietnam");
//		address.setPostalCode("10000");
//		
//		// set shipping address true
//		address.setShipping(true);
//		//attached the user to the address shipping
//		address.setUser(user);
//		
//		//attached the user to the address
//		assertEquals("Failed to add shippping address!" ,true , userDAO.addAddress(address));
//		
//		
//		
//	}
	
	
//	@Test
//	public void testAddAddress() {
//		
//		
//		
//		 //add an user
//		user = new User();
//		user.setFirstName("Minh");
//		user.setLastName("Trang");
//		user.setEmail("minhtrang273706@gmail.com");
//		user.setContactNumber("0988372706");
//		user.setRole("USER");
//		user.setPassword("123456");
//		
//		
//		//add the user 
//		assertEquals("Failed to add user", true, userDAO.addUser(user));
//		
//		
//		//fetch the user 
//		user = userDAO.getByEmail("minhtrang273706@gmail.com");
//		
//		//add the address
//		
//		address = new Address();
//		address.setAddressLineOne("Khu do thi Thinh Gia , Binh Duong");
//		address.setAddressLineTwo("Lavang 2");
//		address.setCity("Tp Binh Duong");
//		address.setState("Binh Duong City");
//		address.setCountry("Vietnam");
//		address.setPostalCode("10000");
//		address.setShipping(true);
//		
//		
//		
//		//attached the user to the address
//		address.setUser(user);
//		
//		assertEquals("Failed to add address!" ,true , userDAO.addAddress(address));
//		

//	}
	
	
	
//	@Test
//	public void testGetAddresses() {
//		user = userDAO.getByEmail("minhtrang273706@gmail.com");
//		
//		assertEquals("Failed to fetch the list of address and size does not match!",1,
//				userDAO.listShippingAddresses(user).size());
//		
//		user = userDAO.getByEmail("tannhn0420@gmail.com");
//		assertEquals("Failed to fetch the billing  address and size does not match!","Tp HCM",
//				userDAO.getBillingAddress(user).getCity());
//	}
	
	
	
}
