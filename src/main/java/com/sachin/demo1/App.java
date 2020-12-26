package com.sachin.demo1;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	
    	Configuration conf = new Configuration().configure().addAnnotatedClass(Aliean.class);
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
    	SessionFactory sf = conf.buildSessionFactory(reg);
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	Query q1 = session.createQuery("from Aliean where id=4");
    	q1.setCacheable(true);
    	Aliean st = (Aliean) q1.uniqueResult();
    	System.out.println(st);
    	tx.commit();
    	session.close();
    	
    	Session session2 = sf.openSession();
    	Transaction tx2 = session2.beginTransaction();
    	Query q2 = session2.createQuery("from Aliean where id=4");
    	q2.setCacheable(true);
    	Aliean st2 = (Aliean) q2.uniqueResult();
    	System.out.println(st2);
    	tx2.commit();
    	session2.close();
        

    }
}
