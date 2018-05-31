package com.hibernate.main;



import com.hibernate.DAO.CustomerDAO;
import com.hibernate.DAO.DAOFactory;
import com.hibernate.TO.CustomerTo;

public class InsertCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CustomerDAO cdao = DAOFactory.getCustomerDAO();
		CustomerTo cto = new CustomerTo("Sachin", "sachin@gamil.com", 99553015124L, "New Delhi", "Active");
		int id = cdao.addCustomer(cto);
		System.out.println("Record successfully inserted and New inserted ID is ---"+id);
	}

}
