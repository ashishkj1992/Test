package com.hibernate.main;



import com.hibernate.DAO.CustomerDAO;
import com.hibernate.DAO.DAOFactory;
import com.hibernate.TO.CustomerTo;

public class InsertCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CustomerDAO cdao = DAOFactory.getCustomerDAO();
		CustomerTo cto = new CustomerTo("Sachin", "sachin@gamil.com", 9487587124L, "New Delhi", "Active");
		CustomerTo ct1 = new CustomerTo("ashish", "ashish@gamil.com", 9487587124L, "New Delhi", "Active");
		CustomerTo ct2 = new CustomerTo("rakesh", "rakesh@gamil.com", 9487587124L, "New Delhi", "Active");
		CustomerTo ct3 = new CustomerTo("mithun", "mithun@gamil.com", 9487587124L, "New Delhi", "Active");
		int id0 = cdao.addCustomer(cto);
		int id1 = cdao.addCustomer(ct1);
		int id2 = cdao.addCustomer(ct2);
		int id3 = cdao.addCustomer(ct3);
		
		System.out.println("Record successfully inserted and New inserted ID is ---"+id0);
		System.out.println("Record successfully inserted and New inserted ID is ---"+id1);
		System.out.println("Record successfully inserted and New inserted ID is ---"+id2);
		System.out.println("Record successfully inserted and New inserted ID is ---"+id3);
	}

}
