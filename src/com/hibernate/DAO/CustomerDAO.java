package com.hibernate.DAO;

import java.util.List;
import java.util.Set;

import com.hibernate.Persistance.Resource.Customer;
import com.hibernate.TO.CustomerTo;


import com.hibernate.Persistance.Resource.Customer;
import com.hibernate.TO.CustomerTo;

public interface CustomerDAO {
	
	public int addCustomer(CustomerTo cust);
	public CustomerTo getCustomerByCid(int cid);
	public void updateCustomer(CustomerTo cust);
	public void deleteCustomerByCid(int cid);
	public List<Customer> getAllCustomerByCity(String city);

}
