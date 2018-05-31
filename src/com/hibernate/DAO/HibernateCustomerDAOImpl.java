package com.hibernate.DAO;

import java.util.ArrayList;
import java.util.List;

import com.hibernate.HTemplate.AHibernateTemplate;
import com.hibernate.Persistance.Resource.Customer;
import com.hibernate.TO.CustomerTo;

public class HibernateCustomerDAOImpl implements CustomerDAO {

	@Override
	public int addCustomer(CustomerTo cust) {
		// TODO Auto-generated method stub
		Customer customer = new Customer(cust.getCname(), cust.getEmail(), cust.getPhone(), cust.getCity(),
				cust.getStatus());

		Integer it = (Integer) AHibernateTemplate.saveObject(customer);
		return it.intValue();
	}

	@Override
	public CustomerTo getCustomerByCid(int cid) {
		// TODO Auto-generated method stub
		
		Customer cust=(Customer) AHibernateTemplate.loadObject(Customer.class, cid);
		CustomerTo cto=new CustomerTo(cust.getCid(), cust.getCname(), cust.getEmail(),
				cust.getPhone(), cust.getCity(), cust.getStatus());
		return cto;
	}

	@Override
	public void updateCustomer(CustomerTo cto) {
		// TODO Auto-generated method stub
		Customer cust=new Customer(cto.getCid(), cto.getCname(), cto.getEmail(),
				cto.getPhone(), cto.getCity(), cto.getStatus());
		AHibernateTemplate.updateObject(cust);
		
		
	}

	@Override
	public void deleteCustomerByCid(int cid) {
		// TODO Auto-generated method stub
		AHibernateTemplate.deleteObject(Customer.class, cid);
		
	}

	@Override
	public List<Customer> getAllCustomerByCity(String city) {
		// TODO Auto-generated method stub
		String hql="from Customer c where c.city=? and c.status='Active'";
		List<Customer> list=AHibernateTemplate.getCustomerByCity(hql, city);
		
		/*List<CustomerTo> list_to=new ArrayList<CustomerTo>();
		
	
		CustomerTo cto=new CustomerTo();
		for(Customer cust:list){
			cto.setCid(cust.getCid());
			cto.setCity(cust.getCity());
			cto.setCname(cust.getCname());
			cto.setEmail(cust.getEmail());
			cto.setPhone(cust.getPhone());
			cto.setStatus(cust.getStatus());
			list_to.add(cto);
		}*/
		
		
		return list;
	}

}
