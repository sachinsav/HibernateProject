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
    	
    	Laptop laptop = new Laptop();
    	laptop.setId(4);
    	laptop.setLname("Asus");
    	
    	Student student = new Student();
    	student.setName("sachin");
    	student.setMarks(100);
    	student.setRollNo(4);
    	student.getLaptops().add(laptop);
    	
    	laptop.getStud().add(student);
    	
    	Configuration conf = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
    	SessionFactory sf = conf.buildSessionFactory(reg);
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	session.save(laptop);
    	session.save(student);
    	tx.commit();
        
//        Configuration conf = new Configuration().configure().addAnnotatedClass(Aliean.class);
//        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
//        SessionFactory sf = conf.buildSessionFactory(reg);
//        Session session = sf.openSession();
//        
//        Transaction tx = session.beginTransaction();
//        session.save(aliean);
//        Aliean gettedAliean = (Aliean)session.get(Aliean.class, 4);
//        tx.commit();
//        System.out.println("manually: "+gettedAliean);
    }
}
