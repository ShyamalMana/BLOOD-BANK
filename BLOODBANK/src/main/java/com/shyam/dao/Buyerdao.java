package com.shyam.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.shyam.dto.Buyer;



public class Buyerdao 
{
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("shyam");
	EntityManager  em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public void Save(Buyer b)
	{
		et.begin();
		em.persist(b);
		et.commit();
	}

	public Buyer findbyemail(String email) {
			Query q=em.createQuery("select b from Buyer b where email =?1");
			q.setParameter(1, email);
			List<Buyer> buyer=q.getResultList();
			if(!buyer.isEmpty())
			{
				return buyer.get(0);
			}else {
			return null;
			}
				
		
	}

	public void update(Buyer buyer) {
		et.begin();
		em.merge(buyer);
		et.commit();
	}

}
