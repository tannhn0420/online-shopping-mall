package com.nattahn.shoppingmallbackend.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nattahn.shoppingmallbackend.dao.UserDAO;
import com.nattahn.shoppingmallbackend.dto.Address;
import com.nattahn.shoppingmallbackend.dto.Cart;
import com.nattahn.shoppingmallbackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired 
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	

	@Override
	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE email = :email";
		try {
			User user = sessionFactory.getCurrentSession()
							.createQuery(selectQuery,User.class)
								.setParameter("email", email)
									.getSingleResult();
			
			if(user != null) {
				return user;
			}
			return null;
			
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Address getBillingAddress(int userId) {
		String selectQuery = "FROM Address WHERE userId = :userId AND billing = :billing";
		
		try {
			return sessionFactory.getCurrentSession()
						.createQuery(selectQuery,Address.class)
							.setParameter("userId", userId)
								.setParameter("billing", true)
									.getSingleResult();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		
		
	}

	@Override
	public List<Address> listShippingAddresses(int userId) {
		String selectQuery = "FROM Address WHERE userId = :userId AND shipping = :shipping";
				
				try {
					return sessionFactory.getCurrentSession()
								.createQuery(selectQuery,Address.class)
									.setParameter("userId", userId)
										.setParameter("shipping", true)
											.getResultList();
					
					
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
	}

	@Override
	public Address getAddress(int addressId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address updateAddress(Address addressId) {
		try {			
			return sessionFactory.getCurrentSession().get(Address.class, addressId);			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
	
}
