package com.kingkingyyk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import model.User;
import ui.manager.AppLoader;

public class SampleCMS {
	
	public static Session session;
	public static void main (String [] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();
		User u=new User();
		u.setUsername("admin");
		u.setPassword("admin");
		session.save(u);
	    t.commit();
	    
	    SampleCMS.session = session;
	    AppLoader.main();
	}
}
