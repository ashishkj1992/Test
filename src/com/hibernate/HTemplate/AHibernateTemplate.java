package com.hibernate.HTemplate;

import java.io.*;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.Persistance.Resource.Customer;
import com.hibernate.utils.AHibernateUtil;

public class AHibernateTemplate {

	public static Object saveObject(Object obj) {
		Object id = null;
		Transaction txn = null;
		try {
			SessionFactory factory = AHibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			txn = session.beginTransaction();
			id = session.save(obj);
			txn.commit();
			session.close();

		} catch (Exception e) {

			e.printStackTrace();
			if (txn != null) {
				txn.rollback();
			}
		}

		return id;
	}

	@SuppressWarnings("rawtypes")
	public static Object loadObject(Class cls, Serializable s) {

		Object o = null;
		Transaction txn = null;

		try {
			SessionFactory sf = AHibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			txn = session.beginTransaction();
			o = session.load(cls, s);
			/* o = session.load(cls, s); */
			// getting problem for exception handling as we are returning the
			// object
			txn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);

			if (txn != null) {
				txn.rollback();
			}
		}
		return o;
	}

	public static void updateObject(Object obj) {

		Transaction txn = null;
		try {
			SessionFactory sf = AHibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			txn = session.beginTransaction();
			session.update(obj);
			txn.commit();
			session.close();
			if (!session.isConnected()) {
				System.out.println("Record Successfully updated !!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No Existing Record found for update");
			if (txn != null) {
				txn.rollback();
			}
		}

	}

	@SuppressWarnings("rawtypes")
	public static void deleteObject(Class cls, Serializable s) {

		Transaction txn = null;
		try {
			SessionFactory sf = AHibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			txn = session.beginTransaction();

			/*
			 * try{ session.load(cls, s);
			 * 
			 * }catch(Exception e){ System.out.println("No Record found");
			 * e.printStackTrace(); }
			 */

			Object o = session.load(cls, s);
			session.delete(o);
			txn.commit();
			session.close();
			if (!session.isConnected()) {
				System.out.println("Record Deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No Existing Record found for Deletion");
			if (txn != null) {
				txn.rollback();
			}
		}
	}

	public static List<Customer> getCustomerByCity(String hql, Object... args) {

		Transaction txn = null;
		List<Customer> list = null;
		try {
			SessionFactory sf = AHibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			txn = session.beginTransaction();
			Query query = session.createQuery(hql);
			for (int i = 0; i < args.length; i++) {
				query = query.setParameter(i, args[i]);
			}
			list = query.list();
			txn.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			if (txn != null) {
				txn.rollback();
			}
		}
		return list;
	}
}
