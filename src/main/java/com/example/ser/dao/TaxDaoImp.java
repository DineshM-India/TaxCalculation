package com.example.ser.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ser.model.Tax;



@Repository
public class TaxDaoImp implements TaxDao {
	
	Configuration connect = new Configuration().configure().addAnnotatedClass(Tax.class);
	StandardServiceRegistryBuilder ssr = new StandardServiceRegistryBuilder().applySettings(connect.getProperties());
	
    @Autowired
	private SessionFactory sessionfact =  connect.buildSessionFactory();
	

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public List<Tax> listTax() {
		Session session = this.sessionfact.openSession();
		session.beginTransaction();
		List<Tax> taxlist = session.createQuery("from Tax").list();
		for (int i = 0; i < taxlist.size(); i++) {
			Tax tax = taxlist.get(i);
		}
		return taxlist;
	}

	@Override
	public Tax getById(int id) {
		Session session = this.sessionfact.openSession();
		Tax tax = (Tax)session.get(Tax.class, id);
		return tax;
	}

	@Override
	public void deleteById(int id) {
		Session session = this.sessionfact.openSession();
	    Transaction tx = session.beginTransaction();
		Tax tax = (Tax)session.get(Tax.class, id);
		if(tax!= null) {
			session.delete(tax);

		}
		tx.commit();
	}

	@Override
	public Tax saveTax(Tax tax) {
	    Session session = this.sessionfact.openSession();
	    Transaction tx = session.beginTransaction();
		session.saveOrUpdate(tax);
		tx.commit();
		return tax;
		
	}


}
