package com.hibernate.main;

import java.util.Date;

import com.hibernate.DAO.CustomerDAO;
import com.hibernate.DAO.DAOFactory;
import com.hibernate.TO.CustomerTo;

public class UpdateCustomer {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CustomerDAO cdao = DAOFactory.getCustomerDAO();

		try {
			CustomerTo cto = cdao.getCustomerByCid(10);
			cto.setCname("sachin_U_" + new Date().getHours());
			cto.setEmail("sachin_updated@gmail.com");
			cto.setPhone(8884172244L);
			cdao.updateCustomer(cto);

			CustomerTo customer = cdao.getCustomerByCid(cto.getCid());

			if (customer != null) {
				System.out.println(customer.getCid() + "\t" + customer.getCname() + "\t" + customer.getEmail() + "\t"
						+ customer.getPhone() + "\t" + customer.getStatus());
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("No existing Record available for Updation");
			System.out.println("Updation un-successfull !!!");

		}

	}

}
