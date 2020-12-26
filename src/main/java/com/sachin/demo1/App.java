package com.sachin.demo1;

import java.util.List;

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
    	
    	Aliean st = (Aliean) session.get(Aliean.class, 4);
    	System.out.println(st);
    	tx.commit();
    	session.close();
    	
    	Session session2 = sf.openSession();
    	Transaction tx2 = session2.beginTransaction();
    	Aliean st2 = (Aliean) session2.get(Aliean.class, 4);
    	System.out.println(st2);
    	tx2.commit();
    	session2.close();
        

    }
}
