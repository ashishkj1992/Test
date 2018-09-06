package com.hibernate.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
/*import org.hibernate.cfg.AnnotationConfiguration;*/
import org.hibernate.cfg.Configuration;

public class AHibernateUtil {
	
	static SessionFactory factory;
	
	static{
		/*AnnotationConfiguration cfg=new AnnotationConfiguration();*/
		Configuration cfg=new Configuration();
		cfg=cfg.configure();
		StandardServiceRegistryBuilder ssrBuilder = new StandardServiceRegistryBuilder();
		StandardServiceRegistry ssRegistry= ssrBuilder.applySettings(cfg.getProperties()).build();
		factory=cfg.buildSessionFactory(ssRegistry);
	}

	public static SessionFactory getSessionFactory(){
		return factory;
	}
}
