package com.sachin.demo1;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
/*
 * get is used for get the object, it return the actual object if found else return null
 * load is used for get the object, it return the proxy object(proxy object return object when we will use it) if found else throws Object not found exception
 */
public class LifeCycleMethod {
	public static void main(String[] args) {
		
		Configuration conf = new Configuration().configure().addAnnotatedClass(UpdatedLaptop.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		SessionFactory sf = conf.buildSessionFactory(reg);
		Session session = sf.openSession();
		session.beginTransaction();
		
		UpdatedLaptop ulap = new UpdatedLaptop();
		ulap.setId(18);
		ulap.setName("Laptop 12");
		ulap.setPrice(2938); // Object is in Transient State
		session.save(ulap); // Object is in Persistent State
		session.getTransaction().commit();
		
		session.evict(ulap); // Object is in Detached State(not in Persistent State)
		session.update(ulap); // Object is re-attached (i.e. in Persistent State)
		//session.delete(ulap); //Object is in removed state
		
		session.beginTransaction();
		ulap.setName("Lap 12"); // This will change value in DB too because object is in Persistent state
		session.getTransaction().commit();
		session.close();
	}

}
