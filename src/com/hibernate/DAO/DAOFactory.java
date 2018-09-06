package com.hibernate.DAO;

public class DAOFactory {

	static CustomerDAO customerDAO;

	static {
		customerDAO = new HibernateCustomerDAOImpl();
	}

	public static CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

}
