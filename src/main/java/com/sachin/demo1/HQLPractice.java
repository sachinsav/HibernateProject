package com.sachin.demo1;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HQLPractice {
	
	public static void main(String[] args) {
		Configuration conf = new Configuration().configure().addAnnotatedClass(Classes.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		SessionFactory sf = conf.buildSessionFactory(reg);
		Session session = sf.openSession();
		session.beginTransaction();
		
		Query q1 = session.createQuery("select id,name from Classes");
		List<Object[]> rs = q1.list();
		for(Object[] cl: rs) {
			System.out.println(cl[0]+" : "+cl[1]);
		}
		session.getTransaction().commit();
		
	}
}
