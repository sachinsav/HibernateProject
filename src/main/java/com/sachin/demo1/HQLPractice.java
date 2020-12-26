package com.sachin.demo1;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
		
		SQLQuery q1 = session.createSQLQuery("select * from classes");
		q1.addEntity(Classes.class);
		List<Classes> lst = q1.list();
		for(Classes cl:lst)
		{
			System.out.println(cl);
		}
		
		
		SQLQuery q2 = session.createSQLQuery("select name from classes");
		List lst2 = q2.list();
		for(Object cl:lst2)
		{
			System.out.println(cl);
		}
		
		SQLQuery q3 = session.createSQLQuery("select * from classes");
		q3.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List lst3 = q3.list();
		for(Object cl:lst3)
		{
			Map m = (Map)cl;
			System.out.println(m.get("id")+" : "+m.get("name"));
		}
		session.getTransaction().commit();
		
	}
}
