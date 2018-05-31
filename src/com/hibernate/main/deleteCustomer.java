package com.hibernate.main;

import com.hibernate.DAO.CustomerDAO;
import com.hibernate.DAO.DAOFactory;

public class deleteCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		CustomerDAO cdao=DAOFactory.getCustomerDAO();
		cdao.deleteCustomerByCid(111);

	}

}
