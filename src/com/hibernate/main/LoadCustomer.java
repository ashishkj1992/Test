package com.hibernate.main;

import java.util.ArrayList;

import com.hibernate.DAO.CustomerDAO;
import com.hibernate.DAO.DAOFactory;
import com.hibernate.TO.CustomerTo;

public class LoadCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CustomerDAO cdao = DAOFactory.getCustomerDAO();

		try {
			CustomerTo customer0 = cdao.getCustomerByCid(1);
			CustomerTo customer1  = cdao.getCustomerByCid(2);
			CustomerTo customer2 = cdao.getCustomerByCid(3);
			CustomerTo customer3 = cdao.getCustomerByCid(4);
			ArrayList<Object> cl=new ArrayList<>();
			cl.add(customer0);
			cl.add(customer1);
			cl.add(customer2);
			cl.add(customer3);
			
			
			
			
			if (cl != null) {
				System.out.println(customer0.getCid() + "\t" + customer0.getCname() + "\t" + customer0.getEmail() + "\t"
						+ customer0.getPhone() + "\t" + customer0.getStatus());
				System.out.println(customer1.getCid() + "\t" + customer1.getCname() + "\t" + customer1.getEmail() + "\t"
						+ customer1.getPhone() + "\t" + customer1.getStatus());

				System.out.println(customer2.getCid() + "\t" + customer2.getCname() + "\t" + customer2.getEmail() + "\t"
						+ customer2.getPhone() + "\t" + customer2.getStatus());

				System.out.println(customer3.getCid() + "\t" + customer3.getCname() + "\t" + customer3.getEmail() + "\t"
						+ customer3.getPhone() + "\t" + customer3.getStatus());

			}
		} catch (Exception ne) {
			ne.printStackTrace();
			System.out.println("No Record available for Inserted ID");
		}
	}
}
