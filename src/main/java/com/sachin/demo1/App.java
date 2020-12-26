package com.sachin.demo1;

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
    	FullName fn = new FullName();
    	fn.setFname("sachin");
    	fn.setLname("sav");
    	fn.setMname("kumar");
        Aliean aliean = new Aliean();
        aliean.setId(5);
        aliean.setFullName(fn);
        aliean.setColor("yellow");
        
        Configuration conf = new Configuration().configure().addAnnotatedClass(Aliean.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
        SessionFactory sf = conf.buildSessionFactory(reg);
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        session.save(aliean);
        Aliean gettedAliean = (Aliean)session.get(Aliean.class, 4);
        tx.commit();
        System.out.println("manually: "+gettedAliean);
    }
}
