package com.hibernate.main;

import java.util.List;

import com.hibernate.DAO.CustomerDAO;
import com.hibernate.DAO.DAOFactory;
import com.hibernate.Persistance.Resource.Customer;
/*import com.hibernate.TO.CustomerTo;*/

public class HQL_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CustomerDAO cdao = DAOFactory.getCustomerDAO();
		List<Customer> list = cdao.getAllCustomerByCity("Delhi");

		if(!list.isEmpty()){
		for (Customer customer : list) {
			System.out.println(customer.getCname() + "\t" + customer.getCid() + "\t" + customer.getCity()+"\t"+
		customer.getEmail()+"\t"+customer.getPhone()+"\t"+customer.getStatus());
		}
		}else{
			System.out.println("Not Record found for the provided city or status not Active");
		}

	}

}
