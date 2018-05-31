package com.hibernate.main;

import com.hibernate.DAO.CustomerDAO;
import com.hibernate.DAO.DAOFactory;
import com.hibernate.TO.CustomerTo;

public class LoadCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CustomerDAO cdao = DAOFactory.getCustomerDAO();

		try {
			CustomerTo customer = cdao.getCustomerByCid(1);
			
			
			if (customer != null) {
				System.out.println(customer.getCid() + "\t" + customer.getCname() + "\t" + customer.getEmail() + "\t"
						+ customer.getPhone() + "\t" + customer.getStatus());
			}
		} catch (Exception ne) {
			ne.printStackTrace();
			System.out.println("No Record available for Inserted ID");
		}
	}
}
